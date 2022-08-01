package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.MemberReceiveAddressEntity;

import java.util.Map;

/**
 * ??Ա?ջ???ַ
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 17:02:59
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

