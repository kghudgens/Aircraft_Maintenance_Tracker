package com.osprey.discrepancy;

import com.osprey.discrepancy.Discrepancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscrepancyRepository extends JpaRepository<Discrepancies, Long> {
}
