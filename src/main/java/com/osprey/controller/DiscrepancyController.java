package com.osprey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.osprey.entities.DiscrepancyEntity;
import com.osprey.services.DiscrepancyService;

import java.util.List;

@RestController
@RequestMapping("discrepancies")
public class DiscrepancyController {
    @Autowired
    private DiscrepancyEntity discrepancies;

    @Autowired
    private DiscrepancyService discrepanciesService;

    public DiscrepancyController(DiscrepancyEntity discrepancies, DiscrepancyService discrepanciesService) {
        this.discrepancies = discrepancies;
        this.discrepanciesService = discrepanciesService;
    }

    @GetMapping("/")
    public ResponseEntity<List> getAllDiscrepancies() {
        List<DiscrepancyEntity> discrepancyList = discrepanciesService.findAll();
        return new ResponseEntity<>(discrepancyList, HttpStatus.OK);
    }

    @PostMapping("/createNewDiscrepancy")
    public DiscrepancyEntity createNewDiscrepancy(@RequestBody DiscrepancyEntity discrepancies) {
        return discrepanciesService.createNewDiscrepancy(discrepancies);
    }

}
