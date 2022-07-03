package com.tuling.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadControllerTest {

    @Test
    public void testThread(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Long s = System.currentTimeMillis();
                System.out.println("线程开始");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束, lasts:"+(System.currentTimeMillis() - s));
            }

        };
        Thread t1 = new Thread(runnable);
    }

}
