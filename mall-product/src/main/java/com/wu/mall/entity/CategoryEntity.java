package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
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
	 * ?????[0-???ʾ??1?ʾ]
	 */
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
	 * ?????λ
	 */
	private String productUnit;
	/**
	 * ?Ʒ???
	 */
	private Integer productCount;

}
