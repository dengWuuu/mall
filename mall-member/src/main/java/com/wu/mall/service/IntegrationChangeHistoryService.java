package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * ???ֱ仯??ʷ??¼
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:02:59
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

