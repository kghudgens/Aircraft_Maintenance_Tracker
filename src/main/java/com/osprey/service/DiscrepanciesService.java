package com.osprey.service;

import com.osprey.entity.Discrepancies;
import com.osprey.repository.DiscrepancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscrepanciesService {

    @Autowired
    private DiscrepancyRepository discrepancyRepository;


    public DiscrepanciesService(DiscrepancyRepository discrepancyRepository){
        this.discrepancyRepository = discrepancyRepository;
    }

    public List<Discrepancies> findAll() {
        return discrepancyRepository.findAll();
    }

    public Discrepancies createNewDiscrepancy(Discrepancies discrepancies) {
        return discrepancyRepository.save(discrepancies);
    }
}
