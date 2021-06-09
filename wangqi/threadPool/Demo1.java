package com.wangqi.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();        //创建单个线程
        Executors.newFixedThreadPool(5);   //创建一个固定的线程池的大小
        Executors.newCachedThreadPool();            //可伸缩的，遇强则强，遇弱则弱


        ExecutorService thredPool=Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                //使用线程池来创建线程
                thredPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 创建成功!");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thredPool.shutdown();
        }


    }

}
