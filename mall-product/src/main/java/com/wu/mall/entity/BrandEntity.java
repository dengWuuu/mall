package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.wu.common.valid.AddGroup;
import com.wu.common.valid.UpdateGroup;
import com.wu.common.valid.UpdateStatusGroup;
import com.wu.common.valid.annotation.ListValue;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Ʒ?
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @NotNull(message = "修改必须指定id", groups = {UpdateGroup.class})
    @Null(message = "新增时id必须为空", groups = AddGroup.class)
    private Long brandId;
    /**
     * 品牌名字
     */
    @NotBlank(message = "品牌名必须提交", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 图片的URL地址
     */
    @URL
    private String logo;
    /**
     * 商品描述
     */
    private String descript;
    /**
     * 展示的状态
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @ListValue(values = {0, 1}, groups = {UpdateGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;
    /**
     * 首字母
     */
    private String firstLetter;
    /**
     * 排序
     */
    private Integer sort;

}
