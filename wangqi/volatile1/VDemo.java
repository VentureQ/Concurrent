package com.wangqi.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo {
    // volatile 不保证原子性
//    private volatile static int num = 0;
    private volatile static AtomicInteger num=new AtomicInteger();

    public  static void add() {
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount() > 2) {   // main gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}