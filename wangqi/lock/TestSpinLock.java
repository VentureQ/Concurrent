package com.wangqi.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        SpinLockTest自旋锁 spinLockTest自旋锁=new SpinLockTest自旋锁();

        new Thread(()->{
            spinLockTest自旋锁.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLockTest自旋锁.myUnLock();
            }
        },"A").start();


        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinLockTest自旋锁.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockTest自旋锁.myUnLock();
            }

        },"B").start();

    }
}
