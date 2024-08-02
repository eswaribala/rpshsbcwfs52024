package com.hsbc.models;

public class VehicleThread extends Thread{
    private Vehicle vehicle;
    public  VehicleThread(Vehicle vehicle){
        this.vehicle=vehicle;
    }

    @Override
    public void run() {
       System.out.print( Bridge.BridgeMessage(vehicle)+"->");
        System.out.println( TollBooth.tollMessage(vehicle));

    }
}
