package com.hsbc.entities;

import com.hsbc.models.Customer;
import com.hsbc.models.FullName;
import com.hsbc.models.Gender;

import java.time.LocalDate;
import java.util.Random;

public class Individual extends Customer {

    private Gender gender;
    private LocalDate dob;

    public Individual() {
    }

    public Individual(long accountNo, FullName name, long contactNo, String email, String password, Gender gender, LocalDate dob) {
        super(accountNo, name, contactNo, email, password);


        this.gender = gender;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Individual{" +super.toString()+
                "gender=" + gender +
                ", dob=" + dob +
                '}';
    }


   @Override
    public boolean equals(Object obj) {
        Individual individual=(Individual) obj;
        return this.contactNo == individual.contactNo;
    }

    @Override
    public int hashCode() {
        return (int)this.contactNo;
    }
}
