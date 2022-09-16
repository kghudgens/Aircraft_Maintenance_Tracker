package com.osprey.services;

import com.osprey.entities.DiscrepancyEntity;
import com.osprey.repository.DiscrepancyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscrepancyService {

    @Autowired
    private DiscrepancyRepository discrepancyRepository;

    public DiscrepancyService(DiscrepancyRepository discrepancyRepository) {
        this.discrepancyRepository = discrepancyRepository;
    }

    public List<DiscrepancyEntity> findAll() {
        return discrepancyRepository.findAll();
    }

    public DiscrepancyEntity createNewDiscrepancy(DiscrepancyEntity discrepancies) {
        return discrepancyRepository.save(discrepancies);
    }
}
