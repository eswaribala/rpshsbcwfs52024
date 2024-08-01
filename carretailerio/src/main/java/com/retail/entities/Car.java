package com.retail.entities;

public class Car {
    private ModelName modelName;
    private byte seatingCapacity;

    public Car() {
    }

    public Car(ModelName modelName, byte seatingCapacity) {
        this.modelName = modelName;
        this.seatingCapacity = seatingCapacity;
    }

    public ModelName getModelName() {
        return modelName;
    }

    public byte getSeatingCapacity() {
        return seatingCapacity;
    }
}
