package com.wangqi.single;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    //禁止指令重排
    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式模式
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        LazyMan lazyMan1 = LazyMan.getInstance();
        // 通过反射破坏单例
        Constructor<LazyMan> constructor = LazyMan.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazyMan lazyMan1 = constructor.newInstance();
        LazyMan lazyMan2 = constructor.newInstance();

        System.out.println(lazyMan1);
        System.out.println(lazyMan2);
    }
}
