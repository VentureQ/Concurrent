package com.wangqi.function;

import java.util.function.Supplier;


/**
 * 供给型接口：没有参数，只有返回值
 */

public class Demo3 {
    public static void main(String[] args) {
        Supplier<String> supplier=new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("get");
                return "null";
            }
        };
        supplier.get();

        //改写
        Supplier<String> supplier1=()->{return "nullllll";};
        System.out.println(supplier1.get());
    }
}
