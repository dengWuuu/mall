package com.wu.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ?Ʒ???
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
@Data
@TableName("pms_spu_comment")
public class SpuCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * ?Ʒ??
	 */
	private String spuName;
	/**
	 * ??????
	 */
	private String memberNickName;
	/**
	 * ???
	 */
	private Integer star;
	/**
	 * ???ip
	 */
	private String memberIp;
	/**
	 * ????ʱ??
	 */
	private Date createTime;
	/**
	 * ?ʾ״̬[0-???ʾ??1-?ʾ]
	 */
	private Integer showStatus;
	/**
	 * ???ʱ?????
	 */
	private String spuAttributes;
	/**
	 * ????
	 */
	private Integer likesCount;
	/**
	 * ?ظ??
	 */
	private Integer replyCount;
	/**
	 * ??ͼƬ/?Ƶ[json??ݣ?[{type:??????,url:?Դ·??}]]
	 */
	private String resources;
	/**
	 * ??
	 */
	private String content;
	/**
	 * ???ͷ?
	 */
	private String memberIcon;
	/**
	 * ?????0 - ?????????????1 - ?????Ļظ?]
	 */
	private Integer commentType;

}
