package com.wu.mall.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Wu
 * @date 2022年08月15日 15:36
 */
@Data
public class AttrVo {

    /**
     * 属性id
     */
    @TableId
    private Long attrId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 是否需要检索
     */
    private Integer searchType;
    /**
     * 图片
     */
    private String icon;
    /**
     *
     */
    private String valueSelect;
    /**
     * ?????0-??????1-????????2-???????????????]
     */
    private Integer attrType;
    /**
     * ??״̬[0 - ?????1 - ??]
     */
    private Long enable;
    /**
     * ?????
     */
    private Long catelogId;
    /**
     * 快速展示
     */
    private Integer showDesc;

    /**
     * 组id
     */
    private Long attrGroupId;
}
