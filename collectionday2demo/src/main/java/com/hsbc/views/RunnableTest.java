package com.hsbc.views;

public class RunnableTest {
    public static void main(String... args){
        //lambda expression
        String name="Parameswari";
        Runnable runnable=()->{
            for(char ch: name.toCharArray()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                System.out.print(ch);
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();



    }

}
