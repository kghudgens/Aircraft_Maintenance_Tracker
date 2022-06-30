package com.osprey.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
