package com.yl;

import com.yl.config.BatchConfiguration;
import com.yl.config.SingleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author syl
 * @Date 2022/05/02/21:42
 * @Description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        testSingleConfiguration();
        testBatchleConfiguration();

    }

    private static void testSingleConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingleConfiguration.class);
        Object user = context.getBean("user");
        System.out.println(user);
    }

    private static void testBatchleConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatchConfiguration.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
