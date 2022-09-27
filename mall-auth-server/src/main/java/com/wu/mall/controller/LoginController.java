package com.wu.mall.controller;


import com.wu.common.constant.AuthServerConstant;
import com.wu.common.exception.BizCodeEnume;
import com.wu.common.utils.R;
import com.wu.mall.feign.ThirdPartFeignService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    ThirdPartFeignService thirdPartFeignService;

    @Autowired
    StringRedisTemplate redisTemplate;
//    @GetMapping("/login.html")
//    public String loginPage(HttpSession session) {
//        return "login";
//    }
//
//    @GetMapping("/reg.html")
//    public String regPage(HttpSession session) {
//        return "reg";
//    }

    @ResponseBody
    @GetMapping("/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone) {
        String code = UUID.randomUUID().toString().substring(0, 5) + "_" + System.currentTimeMillis();

        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (!StringUtils.isEmpty(redisCode)) {
            String[] s = redisCode.split("_");
            long time = Long.parseLong(s[1]);
            if (System.currentTimeMillis() - time < 60000) {
                //60秒
                return R.error(BizCodeEnume.SMS_CODE_EXCEPTION.getCode(), BizCodeEnume.SMS_CODE_EXCEPTION.getMsg());
            }
        }
        //redis缓存验证码,防止同一个手机号再次发送
        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone, code, 10, TimeUnit.MINUTES);


        thirdPartFeignService.sendCode(phone, code);
        return R.ok();
    }
}
