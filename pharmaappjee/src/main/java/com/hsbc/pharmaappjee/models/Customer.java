package com.hsbc.pharmaappjee.models;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String dob;
    private String email;
    private String password;

    public Customer(String name, String dob, String email, String password) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
