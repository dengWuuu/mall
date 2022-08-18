package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.AttrAttrgroupRelationEntity;
import com.wu.mall.entity.AttrEntity;
import com.wu.mall.vo.AttrGroupRelationVo;
import com.wu.mall.vo.AttrRespVo;
import com.wu.mall.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * ?Ʒ??
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 插入一个属性，和他对应的分组
     *
     * @param attr 属性
     */
    void saveAttr(AttrVo attr);

    /**
     * 获取分类具有的属性
     *
     * @param params    条件
     * @param catelogId 分类id
     * @param type
     * @return page
     */
    PageUtils queryPageAttr(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    /**
     * 根据分组id找出其所有分组属性
     *
     * @param attrGroupId id
     * @return 属性
     */
    List<AttrEntity> getRelationAttr(Long attrGroupId);

    void deleteRelation(List<AttrAttrgroupRelationEntity> attrGroupRelationVos);

    /**
     * 找出没有分组的属性
     * @param attrGroupId
     * @param params
     * @return
     */
    PageUtils getNoRelationAttr(Long attrGroupId, Map<String, Object> params);
}

