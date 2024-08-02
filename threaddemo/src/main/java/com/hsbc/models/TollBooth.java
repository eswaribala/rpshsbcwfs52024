package com.hsbc.models;

public class TollBooth {

    public static String tollMessage(Vehicle vehicle){
        return vehicle.getRegNo()+"->crossed the toll";

    }
}
