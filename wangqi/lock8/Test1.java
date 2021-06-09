package com.wangqi.lock8;

import java.lang.ref.PhantomReference;
import java.util.concurrent.TimeUnit;

public class Test1{
    public static void main(String[] args) {
        Phone phone=new Phone();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"A").start();

    }
}



class Phone{
    public synchronized void sendSms(){
        System.out.println("发短信");
    }
    public synchronized  void call(){
        System.out.println("打电话");
    }
}
