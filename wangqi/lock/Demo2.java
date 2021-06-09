package com.wangqi.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone=new Phone1();

        new Thread(()->{
            phone.sms();
        },"A").start();


        // TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}


class Phone1{

    Lock lock=new ReentrantLock();


    public void sms(){
        lock.lock();//此时拿到sms的锁，也会把内层的call锁也拿到！！！！！！！
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    };

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    };

}