package com.osprey.aircraft;

import com.osprey.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalLong;

@Service
public class AircraftServices{

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private Aircraft aircraft;

    public AircraftServices(AircraftRepository aircraftRepository, Aircraft aircraft){
        this.aircraftRepository = aircraftRepository;
        this.aircraft = aircraft;
    }

    public AircraftServices() {

    }

    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    public Aircraft findAircraftByBuno(int buno) {
        if(aircraftRepository.findAircraftByBuno(buno) == null){
            throw new ResourceNotFoundException("Aircraft with this BUNO does not exist in the system.");
        }
       return aircraftRepository.findAircraftByBuno(buno);
    }

    public Aircraft save(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
