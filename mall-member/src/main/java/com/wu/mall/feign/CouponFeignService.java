package com.wu.mall.feign;

import com.wu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wu
 * @date 2022年08月01日 18:39
 */
@FeignClient("mall-coupon")
public interface CouponFeignService {
    @RequestMapping("/mall/coupon/member/list")
    R mem();
}
