package com.hsbc.models;

public class HSBCClock extends  Clock implements Runnable{
    private int count;
    public HSBCClock(int count){
        this.count=count;
    }
    @Override
    public void tick() {
           System.out.print("tick");
    }

    @Override
    public void tock() {
            System.out.print("tock");
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        for(int counter=0;counter<count;counter++) {
            tick();
            System.out.print(counter);
            tock();
            System.out.print(counter);
            System.out.println("\n");
        }

    }
}
