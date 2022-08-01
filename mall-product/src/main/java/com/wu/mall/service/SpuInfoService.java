package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu?Ϣ
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

