package com.osprey.aircraft;

import com.osprey.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The AircraftServices class represents the service layer of the API. It receives request from the AircraftController
 * and handles the request to the persistence layer.
 */
@Service
public class AircraftServices{

    // Inject both the aircraft repository and aircraft entity
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

    /**
     * @return List of all aircraft in the database
     */
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    /**
     * Method returns an aircraft by its BUNO number. A BUNO is the unique identifier for every single aircraft sold
     * determined by the manufacturer. For example, Aircraft 12, Type MV-22 Osprey, BUNO 168288
     *
     * @param buno unique aircraft identifier
     * @return the aircraft resource that matches the buno or ResourceNotFoundException
     */
    public Aircraft findAircraftByBuno(int buno) {
        if(aircraftRepository.findAircraftByBuno(buno) == null){
            throw new ResourceNotFoundException("Aircraft with this BUNO does not exist in the system.");
        }
       return aircraftRepository.findAircraftByBuno(buno);
    }

    /**
     *
     * @param aircraft Payload of the aircraft to be saved, sent to the service layer from the AircraftContoller method
     * @return the aircraft resource saved
     */
    public Aircraft save(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
