package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu?Ϣ
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ?Ʒid
	 */
	@TableId
	private Long id;
	/**
	 * ?Ʒ???
	 */
	private String spuName;
	/**
	 * ?Ʒ??
	 */
	private String spuDescription;
	/**
	 * ?????d
	 */
	private Long catalogId;
	/**
	 * Ʒ?id
	 */
	private Long brandId;
	/**
	 * 
	 */
	private BigDecimal weight;
	/**
	 * ????̬[0 - ??ܣ?1 - ???
	 */
	private Integer publishStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
