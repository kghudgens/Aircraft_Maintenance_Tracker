package com.osprey;

import com.osprey.entities.AircraftEntity;
import com.osprey.entities.DiscrepancyEntity;
import com.osprey.repository.AircraftRepository;
import com.osprey.services.AircraftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories({ "com.osprey.aircraft", "com.osprey.discrepancy" })
@ComponentScan({ "com.osprey.aircraft", "com.osprey.exceptions", "com.osprey.discrepancy", "com.osprey.configuration" })
@EntityScan({ "com.osprey.aircraft", "com.osprey.discrepancy" })
@SpringBootApplication
@EnableAutoConfiguration
public class MaintenanceTrackerApplication implements CommandLineRunner {

	@Autowired
	private AircraftRepository aircraftRepository;

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create the list that will hold the discrepancies
		List<DiscrepancyEntity> osprey00Discrepancies = new ArrayList<DiscrepancyEntity>();
		List<DiscrepancyEntity> osprey44Discrepancies = new ArrayList<DiscrepancyEntity>();
		List<DiscrepancyEntity> osprey12Discrepancies = new ArrayList<DiscrepancyEntity>();

		// create the aircraft
		AircraftEntity osprey00 = new AircraftEntity(168269, "Osprey", osprey00Discrepancies, 00);
		AircraftEntity osprey44 = new AircraftEntity(168302, "Osprey", osprey44Discrepancies, 44);
		AircraftEntity osprey12 = new AircraftEntity(168014, "Osprey", osprey12Discrepancies, 12);

		// create sample discrepancies for the aircraft
		DiscrepancyEntity lCoanda = new DiscrepancyEntity("Left Hand Coanda F(P)", "Left Hand Coanda InOP", true,
				osprey00);
		DiscrepancyEntity gen3 = new DiscrepancyEntity("VFG 3 intermittent", "VFG 3 failing in flight intermittenly",
				true, osprey00);
		DiscrepancyEntity mainSwitch = new DiscrepancyEntity("Corroded Switch", "Corrosion on door main switch", true,
				osprey00);

		DiscrepancyEntity bladeFold = new DiscrepancyEntity("Green Blade Fold", "Right Hand Green Blade wont fold",
				true, osprey44);
		DiscrepancyEntity shearGuage = new DiscrepancyEntity("Shear gauge",
				"Shear gauge is snapped on Left Hand Green Blade", true, osprey44);
		DiscrepancyEntity icing = new DiscrepancyEntity("Right Windscreen", "Right windscreen heating device inop",
				true, osprey44);

		DiscrepancyEntity cFlare = new DiscrepancyEntity("Chaff and Flare", "Chaff and Flare buckets failing", true,
				osprey12);
		DiscrepancyEntity radar = new DiscrepancyEntity("Friend or Foe",
				"Christmas trees for every one, including friend", true, osprey12);
		DiscrepancyEntity rHub = new DiscrepancyEntity("Right Hand hub", "Remove and Replace Right hand hub", true,
				osprey12);

		// add the discrepancies to the lists
		osprey00Discrepancies.add(lCoanda);
		osprey00Discrepancies.add(gen3);
		osprey00Discrepancies.add(mainSwitch);

		osprey44Discrepancies.add(bladeFold);
		osprey44Discrepancies.add(shearGuage);
		osprey44Discrepancies.add(icing);

		osprey12Discrepancies.add(cFlare);
		osprey12Discrepancies.add(radar);
		osprey12Discrepancies.add(rHub);

		// use the services to save the osprey data to the database
		aircraftRepository.save(osprey00);
		aircraftRepository.save(osprey44);
		aircraftRepository.save(osprey12);

	}
}
