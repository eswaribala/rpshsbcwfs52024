package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public static String bankName;
    private long accountNo;
    private FullName name;
    private long contactNo;
    private String email;
    private String password;
    private Address[] addresses;


}
