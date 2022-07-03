package com.tuling.controller;

import com.tuling.common.annotation.MyAnno;
import com.tuling.common.annotation.MyAnno1;
import com.tuling.common.constant.SexEnum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@MyAnno(value = 1, intArr = {1, 2, 3}, str = "jack", s = {"a","b"}, sexEnum = SexEnum.male, annotation1 = @MyAnno1(str1 = "lilei"))
@MyAnno(value = 1, intArr = {1, 2, 3}, s = {"a","b"}, sexEnum = SexEnum.male, annotation1 = @MyAnno1(str1 = "lilei")) //注解有default默认值时，不需要在此指定了。
public class AnnotationTest {

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();
    private static final int THREAD_LOOP_SIZE = 2;


    public static void main(String[] args) {
        /**
         * 一个线程，依附三个ThreadLocal对象
         */
//        test1();
        /**
         * 两个线程，依附三个ThreadLocal对象
         */
//        test2();
        /**
        * 两个线程，依附一个ThreadLocal对象
        */
//        test3();

//        test4();

        /*int num = 129;
        byte b = (byte) num;
        System.out.println(b); //-127  数据溢出
        //数据范围由大到小：double> float> long> int> short> byte
        //小转大：隐式转换； 大转小：强转
        char c = 'c';
        int i = c;
        System.out.println(i);*/

    }


    private static void test1() {
        //线程池变量指定一个线程
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            threadLocal1.set("123");
            threadLocal2.set("234");
            threadLocal3.set("345");
            Thread t = Thread.currentThread();
            System.out.println(Thread.currentThread().getName()+"...."+threadLocal1.get()+"...."+threadLocal2.get()+"...."+threadLocal3.get());
        });
    }

    private static void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(() -> {
                threadLocal1.set("123");
                threadLocal2.set("234");
                threadLocal3.set("345");
                System.out.println(Thread.currentThread().getName()+"...."+threadLocal1.get()+"...."+threadLocal2.get()+"...."+threadLocal3.get());
            });
        }
    }

    private static void test3() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(() -> {
                threadLocal1.set("123");
                System.out.println(Thread.currentThread().getName()+"...."+threadLocal1.get()+"...."+threadLocal2.get()+"...."+threadLocal3.get());
            });
        }
    }

    private static void test4() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int j = 0; j < 10; j++) {
            int finalJ = j;
            executorService.execute(() -> {
                threadLocal1.set(("123" + finalJ));
                System.out.println(Thread.currentThread().getName()+"...."+threadLocal1.get()+"...."+threadLocal2.get()+"...."+threadLocal3.get());
            });
        }
        Thread.yield();
        System.out.println(threadLocal1.get());
    }

}
