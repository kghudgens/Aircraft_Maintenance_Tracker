package com.osprey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({"com.osprey.aircraft","com.osprey.discrepancy"})
@ComponentScan( {"com.osprey.aircraft", "com.osprey.exceptions", "com.osprey.discrepancy", "com.osprey.configuration"})
@EntityScan({"com.osprey.aircraft", "com.osprey.discrepancy"})
@SpringBootApplication
@EnableAutoConfiguration
public class MaintenanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceTrackerApplication.class, args);
	}

}
