package com.hsbc.hospitalmanagement.dtos;

import com.hsbc.hospitalmanagement.models.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private Designation designation;
    private long salary;

}
