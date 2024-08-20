package com.hsbc.hospitalmanagementapi.repositories;

import com.hsbc.hospitalmanagementapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
