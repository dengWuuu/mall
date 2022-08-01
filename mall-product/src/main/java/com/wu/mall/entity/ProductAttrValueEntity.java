package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu??ֵ
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ?Ʒid
	 */
	private Long spuId;
	/**
	 * ??id
	 */
	private Long attrId;
	/**
	 * ???
	 */
	private String attrName;
	/**
	 * ??ֵ
	 */
	private String attrValue;
	/**
	 * ˳?
	 */
	private Integer attrSort;
	/**
	 * ????ʾ??????ʾ????ϣ?0-?? 1-???
	 */
	private Integer quickShow;

}
