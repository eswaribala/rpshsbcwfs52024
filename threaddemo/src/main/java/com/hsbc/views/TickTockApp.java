package com.hsbc.views;

import com.hsbc.models.HSBCClock;

public class TickTockApp {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        HSBCClock hsbcClock=new HSBCClock(60);
        //create thread  with runnable
        Thread thread=new Thread(hsbcClock,"Clock-Thread");
        thread.start();


    }
}
