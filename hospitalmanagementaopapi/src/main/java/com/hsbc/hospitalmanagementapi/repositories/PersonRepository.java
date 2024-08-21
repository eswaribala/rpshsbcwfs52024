package com.hsbc.hospitalmanagementapi.repositories;

import com.hsbc.hospitalmanagementapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
