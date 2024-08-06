package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int sapId;
    private String name;
    private String stream;
    private float percentage;
    private LocalDate dor;
}
