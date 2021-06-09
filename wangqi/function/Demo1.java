package com.wangqi.function;

import java.util.function.Predicate;

/**
 * 断定型接口：一个输入参数，返回值只能是boolean
 */

public class Demo1 {
    public static void main(String[] args) {
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String str) {
                if (str=="hello") return true;
                return false;
            }
        };

        System.out.println(predicate.test("hello1"));

        //改写
        Predicate<String> predicate1=(str)->{
            if (str=="hello") return true;
            return false;
        };

        System.out.println(predicate1.test("hello"));

    }
}
