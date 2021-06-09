package com.wangqi.rw读写锁;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 独占锁（例如;写锁） 一次只能被一个线程占有
 * 共享锁（例如：读锁） 多个线程可以同时占有
 * ReadWriteLock
 * 读-读  可以共存！
 * 读-写  不能共存！
 * 写-写  不能共存！
 */

public class ReadeWriteLockDemo {
    public static void main(String[] args) {
        MyCach myCach=new MyCach();

        for (int i = 1; i <20; i++) {
            final int temp=i;
            new Thread(()->{
                myCach.put(temp+"",temp+"");
            },"Thread"+String.valueOf(temp)).start();
        }

        for (int i = 1; i <20; i++) {
            final int temp=i;
            new Thread(()->{
                myCach.get(String.valueOf(temp));
            },"Thread"+String.valueOf(temp)).start();
        }

    }

}


class MyCach{
    private volatile Map<String,Object> map=new HashMap<>();

    //更加细粒度的操作
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //存、写
    //写入的时候只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    //取、读
    //读的时候所有的人都可以读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o=map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}