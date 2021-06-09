package com.wangqi.function;

import java.util.function.Consumer;


/**
 * 消费型接口，没有返回值，只有参数
 */

public class Demo2 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };

        consumer.accept("hello");

        //改写
        Consumer<String> consumer1=(str)->{
            System.out.println(str);};
        consumer1.accept("consumer");
    }
}
