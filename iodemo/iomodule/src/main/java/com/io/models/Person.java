package com.io.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    protected  String name;
    protected LocalDate dob;

    public Person() {
    }

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
