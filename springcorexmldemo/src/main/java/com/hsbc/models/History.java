package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {

    private String treatmentType;
    private String referredDoctor;
    private String medicine;
}
