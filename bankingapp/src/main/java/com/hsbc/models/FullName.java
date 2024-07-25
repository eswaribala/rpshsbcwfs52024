package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {
    private String firstName;
    private String lastName;
    private String middleName;


}
