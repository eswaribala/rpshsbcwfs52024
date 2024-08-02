package com.hsbc.views;

import com.hsbc.models.Vehicle;
import com.hsbc.models.VehicleThread;

import java.util.Random;

public class JoinDemo {
    public static void main(String[] args){
        VehicleThread[] vehicleThreads=new VehicleThread[5];
        for(int count=0;count<5;count++){
            vehicleThreads[count]=new VehicleThread(new
                    Vehicle("TN01"+new Random()
                    .nextInt(8999,9555)));
            vehicleThreads[count].start();
            try {
                vehicleThreads[count].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
