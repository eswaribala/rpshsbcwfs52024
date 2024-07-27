package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor

public class Individual extends Customer{
    private LocalDate dob;
    private byte age;
    private Gender gender;
    static{
        System.out.println("Sub class Static Block");
    }

    public Individual(){
        System.out.println("Inside Sub class Constructor");
    }
    //instance block
    {
        System.out.println("Sub class Instance Block");
    }


}
