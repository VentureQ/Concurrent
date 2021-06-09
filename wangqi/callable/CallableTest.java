package com.wangqi.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();

        MyThread myThread=new MyThread();
        FutureTask futureTask=new FutureTask(myThread);//适配类

        new Thread(futureTask,"A").start();

        Integer o= (Integer) futureTask.get();
        System.out.println(o);
    }

}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "null";
    }
}
