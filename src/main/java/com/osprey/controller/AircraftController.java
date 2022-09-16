package com.osprey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.osprey.entities.AircraftEntity;
import com.osprey.services.AircraftService;

import java.util.List;

/**
 * Class represents the presentation layer of the API. The class receives
 * requests from a client side application and
 * if valid the AircraftController requests the service layer perform the
 * corresponding action.
 *
 * @author Kevin Hudgens
 */
@RestController
// base
@RequestMapping("aircraft")
public class AircraftController {
    @Autowired
    private AircraftService aircraftServices;

    @Autowired
    private AircraftEntity aircraft;

    public AircraftController(AircraftService aircraftServices, AircraftEntity aircraft) {
        this.aircraftServices = aircraftServices;
        this.aircraft = aircraft;
    }

    /**
     * Get Method that returns all aircraft instances saved to the database
     *
     * @return list of aircraft objects
     */
    @GetMapping("/")
    public List<AircraftEntity> getAllAircraft() {
        return aircraftServices.findAll();
    }

    /**
     * Get Method that allows client to input the buno of an aircraft and retrieve a
     * resource matching the input.
     *
     * @param buno unique aircraft id number
     * @return matching resource
     */
    @GetMapping("/buno/{buno}")
    public AircraftEntity getAircraftByBuno(@PathVariable int buno) {
        return aircraftServices.findAircraftByBuno(buno);
    }

    @PostMapping("/")
    public AircraftEntity newAircraft(@RequestBody AircraftEntity aircraft) {
        return aircraftServices.save(aircraft);
    }

}
