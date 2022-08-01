package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * ??Ʒspu???????
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:57:24
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

