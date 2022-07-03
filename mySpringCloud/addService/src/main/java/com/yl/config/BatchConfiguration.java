package com.yl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author syl
 * @Date 2022/05/02/22:09
 * @Description:
 * @Version 1.0
 */
@Configuration
@ComponentScan({"com.yl.controller", "com.yl.service"})
public class BatchConfiguration {

}
