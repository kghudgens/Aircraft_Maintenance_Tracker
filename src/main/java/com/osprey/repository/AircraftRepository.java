package com.osprey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osprey.entities.AircraftEntity;

@Repository
public interface AircraftRepository extends JpaRepository<AircraftEntity, Long> {

    AircraftEntity findAircraftByBuno(int buno);
}
