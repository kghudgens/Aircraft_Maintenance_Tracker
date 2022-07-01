package com.osprey.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public List<Aircraft> getAllAircraft(){
        return aircraftServices.findAll();
    }

    @GetMapping("/buno/{buno}")
    public Aircraft getAircraftByBuno(@PathVariable int buno){
        return aircraftServices.findAircraftByBuno(buno);
    }

    @PostMapping("/")
    public Aircraft newAircraft(@RequestBody Aircraft aircraft){
        return aircraftServices.save(aircraft);
    }

}
