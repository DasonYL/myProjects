package com.tuling.jucdemo.lock;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Fox
 * 可重入
 * 就是说某个线程已经获得某个锁，在这个锁还没释放的情况下，它可以再次获取该锁而不会出现死锁。
 * 注意：不管是可重入锁还是不可重入锁，锁多少次，就要释放多少次。否则第二个线程将始终无法成功获取这把锁！
 */
@Slf4j
public class ReentrantLockDemo2 {

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
//        method1();
        testReentrent();
    }


    public static void method1() {
        lock.lock();
        try {
            log.debug("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 可能位于另一个类中，而且这个方法也被别的对象调用（有它自己的调用链）
     */
    public static void method2() {
        lock.lock();
        try {
            log.debug("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 可能位于另一个类中，而且这个方法也被别的对象调用（有它自己的调用链）
     */
    public static void method3() {
        lock.lock();
        try {
            log.debug("execute method3");
        } finally {
            lock.unlock();
        }
    }

    public static void testReentrent(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }

}
