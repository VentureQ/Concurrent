package com.wangqi.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockTest自旋锁 {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"=>myLock");

        while (!atomicReference.compareAndSet(null,thread)){

        }

    }

    //解锁
    public void myUnLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"=>myUnLock");
        atomicReference.compareAndSet(thread,null);

    }

}
