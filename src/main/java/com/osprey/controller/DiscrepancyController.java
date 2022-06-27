package com.osprey.controller;

import com.osprey.entity.Aircraft;
import com.osprey.entity.Discrepancies;
import com.osprey.service.AircraftServices;
import com.osprey.service.DiscrepanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("discrepancies")
public class DiscrepancyController {
    @Autowired
    private Discrepancies discrepancies;

    @Autowired
    private DiscrepanciesService discrepanciesService;


    @GetMapping("/")
    public ResponseEntity<List> getAllAircraft(){
        List<Discrepancies> discrepancyList = discrepanciesService.findAll();
       return new ResponseEntity<>(discrepancyList, HttpStatus.OK);
    }

}
