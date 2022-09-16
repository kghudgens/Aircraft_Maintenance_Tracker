package com.osprey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osprey.entities.DiscrepancyEntity;

@Repository
public interface DiscrepancyRepository extends JpaRepository<DiscrepancyEntity, Long> {
}
