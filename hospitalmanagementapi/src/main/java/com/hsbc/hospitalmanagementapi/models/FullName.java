package com.hsbc.hospitalmanagementapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FullName {
    @Column(name="First_Name",nullable = false,length = 100)
    private String firstName;
    @Column(name="Middle_Name",nullable = true,length = 100)
    private String middleName;
    @Column(name="Last_Name",nullable = false,length = 100)
    private String lastName;
}
