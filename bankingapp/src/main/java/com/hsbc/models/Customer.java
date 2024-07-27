package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor

public class Customer {
    public static String bankName;
    private long accountNo;
    private CustomerType customerType;
    private FullName name;
    private long contactNo;
    private String email;
    private String password;
    public static long sequence=10000;
    public static int genOTP;
    private Address[] addresses;

    static{
        System.out.println("Super class Static Block");
    }
    public Customer(int otp){

        if(genOTP==otp){
            System.out.println("OTP Matches...");
        }else
        {
            throw new RuntimeException("OTP is incorrect");
        }

        System.out.println("Inside Super class Constructor");
    }
    public Customer(){


        System.out.println("Inside Super class Constructor");
    }
    //instance block
    {
        System.out.println("Super class Instance Block");
    }

    public String getAccountNo() {
        return customerType+"-"+accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String passwordExpression="^[A-Z]{1}[a-z]{2,4}[^a-zA-Z0-9]{1}[0-9]{4,8}$";
        Pattern pattern= Pattern.compile(passwordExpression);
        if(pattern.matcher(password).matches()) {
            this.password = password;
        }else {
            throw new RuntimeException("Invalid Password");
        }

    }

    public static int getOTP(){
        genOTP= new Random().nextInt(1000,9999);
        return genOTP;
    }
}
