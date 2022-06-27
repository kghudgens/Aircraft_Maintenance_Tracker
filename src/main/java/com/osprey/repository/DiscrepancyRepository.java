package com.osprey.repository;

import com.osprey.entity.Discrepancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscrepancyRepository extends JpaRepository<Discrepancies, Long> {
}
