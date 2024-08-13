package com.hsbc.storage;

import com.hsbc.models.Medicine;

import java.util.Random;

public interface OTPGenerator {

    static int getOTP(){
        return new Random().nextInt(1000,9999);
    }

    default void showMedicine(Medicine medicine){
        System.out.println(medicine);

    }
}
