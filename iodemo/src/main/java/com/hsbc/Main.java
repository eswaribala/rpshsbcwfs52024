package com.hsbc;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable=()->{
            System.out.println("Hi");
        };
        Thread.Builder builder=Thread.ofVirtual().name("Virtual Thread");


        Thread thread=  builder.start(runnable);
        System.out.println(Thread.currentThread().getName());
        thread.join();

    }

}