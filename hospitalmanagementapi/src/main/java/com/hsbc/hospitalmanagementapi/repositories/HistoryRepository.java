package com.hsbc.hospitalmanagementapi.repositories;

import com.hsbc.hospitalmanagementapi.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
