package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu?Ϣ???
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:25:18
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu的描述信息
     * @param descEntity
     */
    void saveSpuinfoDesc(SpuInfoDescEntity descEntity);
}

