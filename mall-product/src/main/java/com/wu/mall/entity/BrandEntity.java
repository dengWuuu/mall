package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	 * Ʒ?id
	 */
	@TableId
	private Long brandId;
	/**
	 * Ʒ??
	 */
	private String name;
	/**
	 * Ʒ?logo???
	 */
	private String logo;
	/**
	 * ???
	 */
	private String descript;
	/**
	 * ?ʾ״̬[0-???ʾ??1-?ʾ]
	 */
	private Integer showStatus;
	/**
	 * ?????ĸ
	 */
	private String firstLetter;
	/**
	 * ??
	 */
	private Integer sort;

}
