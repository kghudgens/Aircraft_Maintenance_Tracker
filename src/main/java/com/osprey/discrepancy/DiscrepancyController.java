package com.osprey.discrepancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("discrepancies")
public class DiscrepancyController {
    @Autowired
    private Discrepancies discrepancies;

    @Autowired
    private DiscrepanciesService discrepanciesService;

    public DiscrepancyController(Discrepancies discrepancies, DiscrepanciesService discrepanciesService){
        this.discrepancies = discrepancies;
        this.discrepanciesService = discrepanciesService;
    }

    @GetMapping("/")
    public ResponseEntity<List> getAllAircraft(){
        List<Discrepancies> discrepancyList = discrepanciesService.findAll();
       return new ResponseEntity<>(discrepancyList, HttpStatus.OK);
    }

    @PostMapping("/createNewDiscrepancy")
    public Discrepancies createNewDiscrepancy(@RequestBody Discrepancies discrepancies){
        return discrepanciesService.createNewDiscrepancy(discrepancies);
    }

}
