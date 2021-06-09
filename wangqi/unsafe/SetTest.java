package com.wangqi.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {
//        Set<String> set=new HashSet<String>();

        //第一种解决方法
//        Set<String> set= Collections.synchronizedSet(new HashSet<String>());

        //第二种解决方法
        Set<String> set=new CopyOnWriteArraySet<String>();

        for (int i = 0; i <=30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
