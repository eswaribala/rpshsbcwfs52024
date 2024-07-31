package com.hsbc.models;



public class Address {
    private String doorNo;
    private String streetName;
    private  String city;
    private  long pinCode;
    private String state;

    public Address() {
    }

    public Address(String doorNo, String streetName, String city, long pinCode, String state) {
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNo='" + doorNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                '}';
    }
}
