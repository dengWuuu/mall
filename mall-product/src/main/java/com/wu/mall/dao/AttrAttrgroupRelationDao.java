package com.wu.mall.dao;

import com.wu.mall.entity.AttrAttrgroupRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 属性和属性组的关联表
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    /**
     * 批量删除
     *
     * @param attrGroupRelationVos vo
     */
    void deleteBatchRelation(@Param("entities") List<AttrAttrgroupRelationEntity> attrGroupRelationVos);
}
