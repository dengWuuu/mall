package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * ?Ʒ??????
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ???d
     */
    @TableId
    private Long catId;
    /**
     * ??????
     */
    private String name;
    /**
     * ?????d
     */
    private Long parentCid;
    /**
     * ?㼶
     */
    private Integer catLevel;
    /**
     * 逻辑删除
     */
    @TableLogic(value = "1", delval = "0")
    private Integer showStatus;
    /**
     * ??
     */
    private Integer sort;
    /**
     * ͼ??ַ
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private List<CategoryEntity> children;
}
