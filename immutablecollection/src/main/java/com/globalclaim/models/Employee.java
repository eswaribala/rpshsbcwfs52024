package com.globalclaim.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@SuperBuilder
public class Employee extends  Person{

    private String designation;
    private String location;
}
