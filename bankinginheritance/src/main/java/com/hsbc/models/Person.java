package com.hsbc.models;

public class Person {

    private String adharCardNo;
    private FullName name;

    public Person() {
    }

    public Person(String adharCardNo, FullName name) {
        this.adharCardNo = adharCardNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "adharCardNo='" + adharCardNo + '\'' +
                ", name=" + name +
                '}';
    }
}
