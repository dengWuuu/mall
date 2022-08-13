package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 分组服务
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询分类属性分组
     * @param params 参数
     * @param catelogId id
     * @return 前端对象
     */
    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

