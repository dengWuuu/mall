package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * ÍË»õÔ­Òò
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:09:20
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

