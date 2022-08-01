package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.AttrEntity;

import java.util.Map;

/**
 * ?Ʒ??
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

