package com.osprey.configuration;

import com.osprey.aircraft.Aircraft;
import com.osprey.aircraft.AircraftServices;
import com.osprey.discrepancy.Discrepancies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Aircraft aircraftConfiguration(){
        return new Aircraft();
    }

    @Bean
    public Discrepancies discrepanciesConfiguration(){
        return new Discrepancies();
    }

}
