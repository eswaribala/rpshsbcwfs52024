package com.hsbc.models;

public class Bridge {

    public static String BridgeMessage(Vehicle vehicle){
        return vehicle.getRegNo()+"->crossed the bridge";

    }
}
