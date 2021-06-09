package com.wangqi.JUC关键字;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        //倒计时
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 0; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"=>Go out!");
                countDownLatch.countDown();//数量-1
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//等待计数器归零，然后再向下执行
        System.out.println("Door closed!");

    }
}
