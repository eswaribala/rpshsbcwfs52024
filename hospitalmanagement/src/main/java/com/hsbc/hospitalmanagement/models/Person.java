package com.hsbc.hospitalmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Component
public class Person {
    protected long personId;
    protected FullName fullName;
   // @Autowired
    protected LocalDate dob;


}
