package com.hsbc.hospitalmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FullName {

    private String firstName;
    private String middleName;
    private String lastName;
}
