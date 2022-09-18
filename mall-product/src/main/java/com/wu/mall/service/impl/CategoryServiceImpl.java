package com.wu.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wu.mall.service.CategoryBrandRelationService;
import com.wu.mall.vo.Catelog2Vo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.experimental.categories.Category;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wu.common.utils.PageUtils;
import com.wu.common.utils.Query;

import com.wu.mall.dao.CategoryDao;
import com.wu.mall.entity.CategoryEntity;
import com.wu.mall.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1. 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        return entities.stream()
                .filter((item) -> item.getParentCid() == 0)
                .peek((item) -> item.setChildren(getChildren(item, entities))).sorted((menu1, menu2) -> menu1.getSort() == null ? 0 : menu1.getSort()
                        - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
    }

    @Override
    public void removeMenueByIds(List<Long> ids) {
        //TODO 1、检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(ids);

    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, path);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[0]);
    }

    @Transactional

    @Caching(evict = {
            @CacheEvict(value = {"category", "product"}, key = "'getLevelOneCategories'"),
            @CacheEvict(value = {"category", "product"}, key = "'getCatalogJson'")
    })
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());

    }

    @Cacheable(value = {"category", "product"}, key = "#root.methodName", sync = true)
    @Override
    public List<CategoryEntity> getLevelOneCategories() {
        return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
    }

    /**
     * 获取分类的方法
     */
    @Override
    @CacheEvict(value = "product", key = "#root.method.name")
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        log.info("查询了数据库.....");
        List<CategoryEntity> selectList = baseMapper.selectList(null);
        List<CategoryEntity> level1Categorys = getParent_cid(selectList, 0L);
        //2、封装数据
        Map<String, List<Catelog2Vo>> parent_cid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            //1、每一个的一级分类，查到这个一级分类的二级分类
            List<CategoryEntity> categoryEntities = getParent_cid(selectList, v.getCatId());
            //2、封装上面面的结果
            List<Catelog2Vo> catelog2Vos = null;
            if (categoryEntities != null) {
                catelog2Vos = categoryEntities.stream().map(l2 -> {
                    Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                    //1、找当前二级分类的三级分类封装成vo
                    List<CategoryEntity> level3Catelog = getParent_cid(selectList, l2.getCatId());
                    if (level3Catelog != null) {
                        List<Catelog2Vo.Catelog3Vo> collect = level3Catelog.stream().map(l3 -> {
                            //2、封装成指定格式
                            return new Catelog2Vo.Catelog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                        }).collect(Collectors.toList());
                        catelog2Vo.setCatalog3List(collect);
                    }
                    return catelog2Vo;
                }).collect(Collectors.toList());
            }
            return catelog2Vos;
        }));
        return parent_cid;
    }

    /**
     * 分布式锁
     *
     * @return
     */
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDbWithRedissonLock() {
        //1. 占领锁
        RLock lock = redissonClient.getLock("catalogJson-lock");
        lock.lock();
        Map<String, List<Catelog2Vo>> dataFromDb;

        try {
            dataFromDb = getDataFromDb();
        } finally {
            lock.unlock();
        }
        return dataFromDb;
    }

    /**
     * Redis分布式锁
     *
     * @return
     */
    public Map<String, List<Catelog2Vo>> getCatalogJsonFromDbWithRedisLock() {
        String uuid = UUID.randomUUID().toString();
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid, 10, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(lock)) {
            //加锁成功
            log.info("获取分布式锁成功.....................");
            Map<String, List<Catelog2Vo>> dataFromDb;
            try {
                dataFromDb = getDataFromDb();
            } finally {
                //删除锁
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                stringRedisTemplate.execute(new DefaultRedisScript<>(script, Long.class), Collections.singletonList("lock"), uuid);
            }
            return dataFromDb;
        } else {
            //失败
            log.info("获取分布式锁失败.......................");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getCatalogJsonFromDbWithRedisLock();
        }
    }

    private Map<String, List<Catelog2Vo>> getDataFromDb() {
        String catelogJSON = stringRedisTemplate.opsForValue().get("catelogJSON");
        if (!StringUtils.isEmpty(catelogJSON)) {
            return JSON.parseObject(catelogJSON, new TypeReference<Map<String, List<Catelog2Vo>>>() {
            });
        }

        System.out.println("查询了数据库.....");
        List<CategoryEntity> selectList = baseMapper.selectList(null);
        List<CategoryEntity> level1Categorys = getParent_cid(selectList, 0L);
        //2、封装数据
        Map<String, List<Catelog2Vo>> parent_cid = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            //1、每一个的一级分类，查到这个一级分类的二级分类
            List<CategoryEntity> categoryEntities = getParent_cid(selectList, v.getCatId());
            //2、封装上面面的结果
            List<Catelog2Vo> catelog2Vos = null;
            if (categoryEntities != null) {
                catelog2Vos = categoryEntities.stream().map(l2 -> {
                    Catelog2Vo catelog2Vo = new Catelog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                    //1、找当前二级分类的三级分类封装成vo
                    List<CategoryEntity> level3Catelog = getParent_cid(selectList, l2.getCatId());
                    if (level3Catelog != null) {
                        List<Catelog2Vo.Catelog3Vo> collect = level3Catelog.stream().map(l3 -> {
                            //2、封装成指定格式
                            return new Catelog2Vo.Catelog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                        }).collect(Collectors.toList());
                        catelog2Vo.setCatalog3List(collect);
                    }
                    return catelog2Vo;
                }).collect(Collectors.toList());
            }
            return catelog2Vos;
        }));
        stringRedisTemplate.opsForValue().set("catelogJSON", JSON.toJSONString(parent_cid), 1, TimeUnit.DAYS);
        return parent_cid;
    }

    private List<CategoryEntity> getParent_cid(List<CategoryEntity> selectList, Long parent_cid) {
        return selectList.stream().filter(item -> Objects.equals(item.getParentCid(), parent_cid)).collect(Collectors.toList());
    }

    private List<Long> findParentPath(Long catelogId, List<Long> path) {
        path.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), path);
        }
        return path;
    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter((entity) -> Objects.equals(entity.getParentCid(), root.getCatId()))
                .peek((menu) -> menu.setChildren(getChildren(menu, all)))
                .sorted((menu1, menu2) -> menu1.getSort() == null ? 0 : menu1.getSort()
                        - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
    }

}