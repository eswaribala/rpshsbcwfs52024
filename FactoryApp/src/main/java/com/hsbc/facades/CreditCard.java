package com.hsbc.facades;

import java.util.Random;

public interface CreditCard {

    static int getOTP(){
        return new Random().nextInt(1000,9999);
    }
    default boolean swipe(long amount){
        return generateDecision();
    }
    private boolean generateDecision(){
        int value=new Random().nextInt(0,5);
        if(value%2==0)
            return true;
        else
            return false;
    }
}
