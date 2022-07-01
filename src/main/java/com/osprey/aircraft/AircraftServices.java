package com.osprey.aircraft;

import com.osprey.aircraft.Aircraft;
import com.osprey.aircraft.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServices{

    @Autowired
    private AircraftRepository aircraftRepository;

    public AircraftServices(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    public Aircraft findAircraftByBuno(int buno) {
        return aircraftRepository.findAircraftByBuno(buno);
    }

    public Aircraft save(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
