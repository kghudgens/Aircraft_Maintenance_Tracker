package com.osprey.aircraft;

import com.osprey.aircraft.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    Aircraft findAircraftByBuno(int buno);
}
