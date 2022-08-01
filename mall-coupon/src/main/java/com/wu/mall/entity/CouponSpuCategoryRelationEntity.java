package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ?Ż?ȯ????????
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:57:24
 */
@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ?Ż?ȯid
	 */
	private Long couponId;
	/**
	 * ??Ʒ????id
	 */
	private Long categoryId;
	/**
	 * ??Ʒ???????
	 */
	private String categoryName;

}
