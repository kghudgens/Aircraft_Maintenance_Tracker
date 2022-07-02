package com.osprey.discrepancy;

import com.osprey.discrepancy.Discrepancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscrepancyRepository extends JpaRepository<Discrepancies, Long> {
}
