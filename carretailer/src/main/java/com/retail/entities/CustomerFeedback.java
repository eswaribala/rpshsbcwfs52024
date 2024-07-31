package com.retail.entities;

public class CustomerFeedback {

    private String name;
    private  ModelName modelName;
    private String city;
    private int drivingComfortRating;
    private int seatComfortRating;

    public CustomerFeedback() {
    }

    public CustomerFeedback(String name, ModelName modelName, String city, int drivingComfortRating, int seatComfortRating) {
        this.name = name;
        this.modelName = modelName;
        this.city = city;
        this.drivingComfortRating = drivingComfortRating;
        this.seatComfortRating = seatComfortRating;
    }

    public String getName() {
        return name;
    }

    public ModelName getModelName() {
        return modelName;
    }

    public String getCity() {
        return city;
    }

    public int getDrivingComfortRating() {
        return drivingComfortRating;
    }

    public int getSeatComfortRating() {
        return seatComfortRating;
    }
}
