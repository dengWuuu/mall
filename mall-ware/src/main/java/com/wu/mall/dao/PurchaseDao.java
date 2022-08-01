package com.wu.mall.dao;

import com.wu.mall.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:11:33
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
