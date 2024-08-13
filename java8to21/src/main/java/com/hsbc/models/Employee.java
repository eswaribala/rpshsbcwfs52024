package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

public non-sealed class Employee extends Person{
    private long employeeId;
    private long salary;
    private String workLocation;
    private Role role;

}
