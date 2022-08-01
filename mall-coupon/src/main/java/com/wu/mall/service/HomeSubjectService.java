package com.wu.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wu.common.utils.PageUtils;
import com.wu.mall.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * ??ҳר???�jd??ҳ?????ܶ?ר?⣬ÿ??ר???????µ?ҳ?棬չʾר????Ʒ??Ϣ??
 *
 * @author Wu
 * @email dengwu.wu@foxmail.com
 * @date 2022-08-01 16:57:24
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

