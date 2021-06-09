package com.wangqi.threadPool;

import java.util.concurrent.*;


/**
 * 自定义线程池
 * 没有线程可用的时候（阻塞队列也没有了，就启动拒绝策略）
 * 1.new ThreadPoolExecutor.AbortPolicy()   线程池不够用了，还有任务，就抛出异常
 * 2.new ThreadPoolExecutor.CallerRunsPolicy()  哪来的哪去
 * 3.new ThreadPoolExecutor.DiscardPolicy()   队列满了，丢掉任务，不会抛出异常
 * 4.new ThreadPoolExecutor.DiscardOldestPolicy()   队列满了，尝试和最早的竞争，也不会抛出异常
 */

public class Demo2 {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());


        ExecutorService threadPoolExecutor=new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()//拒绝策略
        );

        try {
            for (int i = 1; i <=9; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" OK!");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

}

