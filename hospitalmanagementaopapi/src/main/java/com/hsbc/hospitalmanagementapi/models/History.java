package com.hsbc.hospitalmanagementapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="GlobalHistory")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="History_Id")
    private long historyId;
    @Column(name="Treatment_Type",nullable = false,length = 250)
    private String treatmentType;
    @Column(name="Referenced_Doctor_Name",nullable = false,length = 100)
    private String referredDoctorName;
    @Column(name="Medicine",nullable = false,length = 100)
    private String medicine;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Person_Id"),
            name = "Person_Id_FK")
    private Patient patient;
}
