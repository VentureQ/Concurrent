package com.wangqi.lock;


import java.sql.Time;
import java.util.concurrent.TimeUnit;

//可重入锁
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone();

        new Thread(()->{
            phone.sms();
        },"A").start();


       // TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}


class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    };

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");


    };

}