package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String doorNo;
    private String streetName;
    private  String city;
    private  long pinCode;
    private String state;

}
