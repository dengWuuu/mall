package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ??ɱ????
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:57:24
 */
@Data
@TableName("sms_seckill_session")
public class SeckillSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ???????
	 */
	private String name;
	/**
	 * ÿ?տ?ʼʱ?
	 */
	private Date startTime;
	/**
	 * ÿ?ս???ʱ?
	 */
	private Date endTime;
	/**
	 * ????״̬
	 */
	private Integer status;
	/**
	 * ????ʱ?
	 */
	private Date createTime;

}
