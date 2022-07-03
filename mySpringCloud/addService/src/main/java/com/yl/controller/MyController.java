package com.yl.controller;

import com.shigan.YLMybatisConnection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author syl
 * @Date 2022/05/02/17:57
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("myController")
public class MyController {

    @Resource
    private YLMybatisConnection ylMybaticController;



    @RequestMapping("getYLMybatis")
    public String getYlMybaticController(){
        return ylMybaticController.connection();
    }

    @RequestMapping("m1")
    public void M1(){
        System.out.println("hello, M1~!");
    }
}
