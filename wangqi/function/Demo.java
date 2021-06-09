package com.wangqi.function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，一个输出参数
 * 函数型接口，可以用 lambda表达式简化
 */
public class Demo {
    public static void main(String[] args) {
//        Function function=new Function<String,String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
        //改写为函数式接口形式===lambda表达式简化
        Function function=(str)->{return str;};
        System.out.println(function.apply("hello"));

        Function function1=str->str;
        System.out.println(function1.apply("hello"));

    }
}