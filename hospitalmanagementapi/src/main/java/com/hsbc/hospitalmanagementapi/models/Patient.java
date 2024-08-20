package com.hsbc.hospitalmanagementapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//inheritance
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="GlobalPatient")
public class Patient  extends Person{
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Patient_Id")
    private long patientId;
   // private List<History> history;
    @Column(name="Issue",nullable = false,length = 250)
    private String issue;

}
