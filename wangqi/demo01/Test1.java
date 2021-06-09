package com.wangqi.demo01;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        //获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        new Thread(()->{
            System.out.println("hshh");
        },"A").start();
    }
}
