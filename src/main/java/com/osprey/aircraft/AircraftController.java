package com.osprey.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class represents the presentation layer of the API. The class receives requests from a client side application and
 * if valid the AircraftController requests the service layer perform the corresponding action.
 *
 * @author Kevin Hudgens
 */
@RestController
// base
@RequestMapping("aircraft")
public class AircraftController {
    @Autowired
    private AircraftServices aircraftServices;

    @Autowired
    private Aircraft aircraft;

    public AircraftController(AircraftServices aircraftServices, Aircraft aircraft){
        this.aircraftServices = aircraftServices;
        this.aircraft = aircraft;
    }

    /**
     *  Get Method that returns all aircraft instances saved to the database
     *
     * @return list of aircraft objects
     */
    @GetMapping("/")
    public List<Aircraft> getAllAircraft(){
        return aircraftServices.findAll();
    }

    /**
     *  Get Method that allows client to input the buno of an aircraft and retrieve a resource matching the input.
     *
     * @param buno unique aircraft id number
     * @return matching resource
     */
    @GetMapping("/buno/{buno}")
    public Aircraft getAircraftByBuno(@PathVariable int buno){
        return aircraftServices.findAircraftByBuno(buno);
    }

    @PostMapping("/")
    public Aircraft newAircraft(@RequestBody Aircraft aircraft){
        return aircraftServices.save(aircraft);
    }

}
