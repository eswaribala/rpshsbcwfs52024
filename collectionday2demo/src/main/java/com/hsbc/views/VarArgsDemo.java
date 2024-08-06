package com.hsbc.views;

public class VarArgsDemo {
    public static void main(String... args){

       // change();
        change(10);
       // change(10,20);
      //  change(10,20,30);
    }
    public static void change(Integer... data){
        System.out.println("int varargs");
    }
    public static void change(int... data){
        System.out.println("int varargs");
    }
    public static void change(int data){
        System.out.println("int args");
    }

}
