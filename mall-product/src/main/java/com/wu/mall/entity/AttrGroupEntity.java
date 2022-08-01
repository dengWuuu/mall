package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ?????
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ???d
	 */
	@TableId
	private Long attrGroupId;
	/**
	 * ??
	 */
	private String attrGroupName;
	/**
	 * ??
	 */
	private Integer sort;
	/**
	 * ??
	 */
	private String descript;
	/**
	 * ?ͼ??
	 */
	private String icon;
	/**
	 * ?????d
	 */
	private Long catelogId;

}
