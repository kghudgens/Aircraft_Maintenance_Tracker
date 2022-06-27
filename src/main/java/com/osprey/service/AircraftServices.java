package com.osprey.service;

import com.osprey.entity.Aircraft;
import com.osprey.repository.AircraftRepository;
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

}
