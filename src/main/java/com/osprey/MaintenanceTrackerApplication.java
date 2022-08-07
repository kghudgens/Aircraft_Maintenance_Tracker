package com.osprey;

import com.osprey.aircraft.Aircraft;
import com.osprey.aircraft.AircraftRepository;
import com.osprey.aircraft.AircraftServices;
import com.osprey.discrepancy.Discrepancies;
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

@EnableJpaRepositories({"com.osprey.aircraft","com.osprey.discrepancy"})
@ComponentScan( {"com.osprey.aircraft", "com.osprey.exceptions", "com.osprey.discrepancy", "com.osprey.configuration"})
@EntityScan({"com.osprey.aircraft", "com.osprey.discrepancy"})
@SpringBootApplication
@EnableAutoConfiguration
public class MaintenanceTrackerApplication implements CommandLineRunner {

	@Autowired
	private AircraftRepository aircraftRepository;

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		// Create the list that will hold the discrepancies
		List<Discrepancies> osprey00Discrepancies = new ArrayList<Discrepancies>();
		List<Discrepancies> osprey44Discrepancies = new ArrayList<Discrepancies>();
		List<Discrepancies> osprey12Discrepancies = new ArrayList<Discrepancies>();

		// create the aircraft
		Aircraft osprey00 = new Aircraft(168269,"Osprey", osprey00Discrepancies, 00);
		Aircraft osprey44 = new Aircraft(168302, "Osprey", osprey44Discrepancies, 44);
		Aircraft osprey12 = new Aircraft(168014, "Osprey", osprey12Discrepancies, 12);

		// create sample discrepancies for the aircraft
		Discrepancies lCoanda = new Discrepancies("Left Hand Coanda F(P)", "Left Hand Coanda InOP", true, osprey00);
		Discrepancies gen3 = new Discrepancies("VFG 3 intermittent", "VFG 3 failing in flight intermittenly", true, osprey00);
		Discrepancies mainSwitch = new Discrepancies("Corroded Switch", "Corrosion on door main switch", true, osprey00);

		Discrepancies bladeFold = new Discrepancies("Green Blade Fold", "Right Hand Green Blade wont fold", true, osprey44);
		Discrepancies shearGuage = new Discrepancies("Shear gauge", "Shear gauge is snapped on Left Hand Green Blade", true, osprey44);
		Discrepancies icing = new Discrepancies("Right Windscreen", "Right windscreen heating device inop", true, osprey44);

		Discrepancies cFlare = new Discrepancies("Chaff and Flare", "Chaff and Flare buckets failing", true, osprey12);
		Discrepancies radar = new Discrepancies("Friend or Foe", "Christmas trees for every one, including friend", true, osprey12);
		Discrepancies rHub = new Discrepancies("Right Hand hub", "Remove and Replace Right hand hub", true, osprey12);

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
