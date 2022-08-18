package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.AttrAttrgroupRelationEntity;
import com.wu.mall.vo.AttrGroupRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 属性和属性分组关联属表业务
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加属性和属性组的关联
     * @param vos
     */
    void saveBatchRelation(List<AttrGroupRelationVo> vos);
}

