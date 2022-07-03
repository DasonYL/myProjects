package com.yl.config;

import com.yl.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author syl
 * @Date 2022/05/02/21:39
 * @Description:
 * @Version 1.0
 */
@Configuration
public class SingleConfiguration {

    @Bean
    public User user(){
        return new User();
    }
}
