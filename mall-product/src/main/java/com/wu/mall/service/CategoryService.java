package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品服务
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查出所有分类，组装成树状结构返回
     * @return
     */
    List<CategoryEntity> listWithTree();

    /**
     * 删除分类，如果有孩子则不能删除
     * @param ids id
     */
    void removeMenueByIds(List<Long> ids);
}

