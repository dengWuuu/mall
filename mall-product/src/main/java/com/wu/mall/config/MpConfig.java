package com.wu.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Wu
 * @date 2022年08月10日 21:30
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.wu.mall.dao")
public class MpConfig {
    //引入分页插件

}
