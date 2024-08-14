package com.globalclaim;

import com.globalclaim.models.AnimateName;

public class VirtualThreadDemo {
    public static void main(String[] args){

        //create virtual thread
       Thread.Builder threadBuilder=Thread.ofVirtual().name("Test");
       Thread thread= threadBuilder.start(new AnimateName("Param","VirtualThread"));
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
