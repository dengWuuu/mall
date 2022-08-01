package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu?Ϣ???
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ?Ʒid
	 */
	@TableId
	private Long spuId;
	/**
	 * ?Ʒ???
	 */
	private String decript;

}
