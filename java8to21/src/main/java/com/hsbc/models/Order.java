package com.hsbc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public record Order(List<Medicine> medicineList, LocalDate purchasedDate, float billAmount){

}