package com.yl.config;

import com.shigan.YLMybatisConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author syl
 * @Date 2022/05/02/23:08
 * @Description:
 * @Version 1.0
 */
@Configuration
public class ThirdDependencyConfiguration {

/*
 * 引入了第三方依赖后，需要将三方依赖交给spring Ioc管理，才能通过@AutoWired或者@Resource被注入到使用者类中去。
 * 这是第一种方式：调用方把被调用方交给spring Ioc管理
 * 我们还可以尝试第二种方式：被调用方自己把自己交给spring Ioc管理
*/
//    @Bean
//    public YLMybatisConnection getYLMybatis(){
//        return new YLMybatisConnection();
//    }

}
