package com.wu.mall.service.impl;

import lombok.AllArgsConstructor;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wu.common.utils.PageUtils;
import com.wu.common.utils.Query;

import com.wu.mall.dao.CategoryDao;
import com.wu.mall.entity.CategoryEntity;
import com.wu.mall.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
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

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter((entity) -> Objects.equals(entity.getParentCid(), root.getCatId()))
                .peek((menu) -> menu.setChildren(getChildren(menu, all)))
                .sorted((menu1, menu2) -> menu1.getSort() == null ? 0 : menu1.getSort()
                        - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
    }

}