package com.wu.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MallWebConfig implements WebMvcConfigurer {

    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /**
         *     @GetMapping("/login.html")
         *     public String loginPage(){
         *
         *         return "login";
         *     }
         */
        registry.addViewController("/login.html").setViewName("login");
        //只是get请求能映射
        registry.addViewController("/reg.html").setViewName("reg");
    }
}
