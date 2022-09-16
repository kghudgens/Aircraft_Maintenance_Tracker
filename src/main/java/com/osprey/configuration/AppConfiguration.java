package com.osprey.configuration;

import com.osprey.entities.AircraftEntity;
import com.osprey.entities.DiscrepancyEntity;
import com.osprey.services.AircraftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public AircraftEntity aircraftConfiguration() {
        return new AircraftEntity();
    }

    @Bean
    public DiscrepancyEntity discrepanciesConfiguration() {
        return new DiscrepancyEntity();
    }

}
