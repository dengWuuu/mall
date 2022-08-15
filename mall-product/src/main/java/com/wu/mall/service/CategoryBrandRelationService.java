package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌所在分类的关联表
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 存储品牌和分类关联表的详细字段
     * @param categoryBrandRelation
     */
    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    /**
     * 更新品牌
     * @param brandId 品牌id
     * @param name 品牌名字
     */
    void updateBrand(Long brandId, String name);

    /**
     * 更新分类表中
     * @param catId
     * @param name
     */
    void updateCategory(Long catId, String name);
}

