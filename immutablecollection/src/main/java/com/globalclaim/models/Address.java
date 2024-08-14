package com.globalclaim.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String doorNo;
    private String streetName;
    private String city;
    private String pinCode;
}
