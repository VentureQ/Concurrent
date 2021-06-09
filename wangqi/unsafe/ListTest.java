package com.wangqi.unsafe;



import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list= Arrays.asList("1","2","3");
//        list.forEach(System.out::println);

        //第一种解决方案
//        List<String> list=new Vector<String>();

        //第二种解决方案
//        List<String> list= Collections.synchronizedList(new ArrayList<String>());

        //第三种解决方案
//        List<String> list= new CopyOnWriteArrayList<String>();

         /**CopyOnWrite 写入时复制 COW 计算机程序设计的一种优化策略
         多个线程调用的时候，list读取的时候，固定的，写入（覆盖）， 在写入的时候避免覆盖，造成数据问题！读写分离
         CopyOnWriteArrayList 比 Vector牛逼的地方是底层应用了Lock锁，而Vector应用了synchronized
          **/

        List<String> list= new CopyOnWriteArrayList<String>();


        for (int i = 0; i <=10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
