package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ??&???????
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ??id
	 */
	private Long attrId;
	/**
	 * ?????d
	 */
	private Long attrGroupId;
	/**
	 * ??????
	 */
	private Integer attrSort;

}
