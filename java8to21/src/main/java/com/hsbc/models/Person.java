package com.hsbc.models;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public sealed class Person permits Employee,Customer {
    protected long id;
    protected String name;
    protected LocalDate dob;
    protected Gender gender;
}
