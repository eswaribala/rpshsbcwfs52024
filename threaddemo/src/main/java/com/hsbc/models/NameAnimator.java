package com.hsbc.models;

public class NameAnimator extends Thread{
    private String name;

    public NameAnimator(String threadName, String name) {
        super(threadName);
        this.name = name;
    }

    @Override
    public void run() {

        for(char ch : name.toCharArray()){
            System.out.print(ch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
