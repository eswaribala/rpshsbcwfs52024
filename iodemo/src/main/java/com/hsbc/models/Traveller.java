package com.hsbc.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Traveller extends Person implements Serializable {

    private String destination;
    private transient int passCode;

    public Traveller() {
    }

    public Traveller(String name, LocalDate dob, String destination, int passCode) {
        super(name, dob);
        this.destination = destination;
        this.passCode = passCode;
    }



    @Override
    public String toString() {
        return "Traveller{" +
                "destination='" + destination + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
