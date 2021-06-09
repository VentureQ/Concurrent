package com.wangqi.callable;



public class Test {

    public static void main(String[] args) {
        ImpITerst impITerst=new ImpITerst();

        boolean result= impITerst instanceof ImpITerst;
        System.out.println(result);

        Integer i=1;
        boolean result1=i instanceof Integer;
        System.out.println(result1);


    }
}


interface Itest{
    void hello();
}

class ImpITerst implements Itest{

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
