package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ??Ա
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:02:59
 */
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ??Ա?ȼ?id
	 */
	private Long levelId;
	/**
	 * ?û???
	 */
	private String username;
	/**
	 * ???
	 */
	private String password;
	/**
	 * ?ǳ
	 */
	private String nickname;
	/**
	 * ?ֻ????
	 */
	private String mobile;
	/**
	 * ???
	 */
	private String email;
	/**
	 * ͷ?
	 */
	private String header;
	/**
	 * ?Ա
	 */
	private Integer gender;
	/**
	 * ???
	 */
	private Date birth;
	/**
	 * ???ڳ??
	 */
	private String city;
	/**
	 * ְҵ
	 */
	private String job;
	/**
	 * ????ǩ??
	 */
	private String sign;
	/**
	 * ?û???Դ
	 */
	private Integer sourceType;
	/**
	 * ???
	 */
	private Integer integration;
	/**
	 * ?ɳ?ֵ
	 */
	private Integer growth;
	/**
	 * ????״̬
	 */
	private Integer status;
	/**
	 * ע??ʱ?
	 */
	private Date createTime;

}
