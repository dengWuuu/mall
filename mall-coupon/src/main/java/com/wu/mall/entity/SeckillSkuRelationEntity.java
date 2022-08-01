package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ??ɱ???Ʒ????
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:57:24
 */
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ?id
	 */
	private Long promotionId;
	/**
	 * ?????id
	 */
	private Long promotionSessionId;
	/**
	 * ??Ʒid
	 */
	private Long skuId;
	/**
	 * ??ɱ?۸
	 */
	private BigDecimal seckillPrice;
	/**
	 * ??ɱ????
	 */
	private BigDecimal seckillCount;
	/**
	 * ÿ???޹?????
	 */
	private BigDecimal seckillLimit;
	/**
	 * ???
	 */
	private Integer seckillSort;

}
