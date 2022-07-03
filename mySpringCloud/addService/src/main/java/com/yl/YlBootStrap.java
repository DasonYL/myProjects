package com.yl;


import com.shigan.YLConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author syl
 * @Date 2022/05/02/12:02
 * @Description:
 * @Version 1.0
 */
@SpringBootApplication
@RestController
@Import(YLConfiguration.class)
public class YlBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(YlBootStrap.class, args);
    }

}
