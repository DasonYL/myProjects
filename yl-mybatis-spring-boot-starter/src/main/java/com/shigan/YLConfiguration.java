package com.shigan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author syl
 * @Date 2022/05/03/11:09
 * @Description:
 * @Version 1.0
 */
@Configuration
public class YLConfiguration {
    @Bean
    public YLMybatisConnection getYLMybatis(){
        return new YLMybatisConnection();
    }
}
