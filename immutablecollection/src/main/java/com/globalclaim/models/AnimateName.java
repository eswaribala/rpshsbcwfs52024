package com.globalclaim.models;

public class AnimateName implements Runnable{
    private String name;
    public  AnimateName(String name, String threadName){
        this.name=name;
        Thread.currentThread().setName(threadName);
    }
    @Override
    public void run() {
        for(char ch : this.name.toCharArray()){
            System.out.print(ch);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
