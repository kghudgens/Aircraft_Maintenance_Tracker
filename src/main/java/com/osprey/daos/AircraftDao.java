package com.osprey.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.osprey.entities.AircraftEntity;

public class AircraftDao implements Dao<AircraftEntity> {

    private List<AircraftEntity> aircraftList = new ArrayList<>();

    public AircraftDao() {

    }

    @Override
    public Optional<AircraftEntity> get(int id) {
        return Optional.ofNullable(aircraftList.get((int) id));
    }

    @Override
    public List<AircraftEntity> getAll() {
        return aircraftList;
    }

    @Override
    public void save(AircraftEntity aircraft) {
        aircraftList.add(aircraft);
    }

    @Override
    public void update(AircraftEntity aircraft, String[] params) {
        aircraft.setAircraftType(Objects.requireNonNull(params[0], "Aircraft Type cannot be null"));
        try {
            aircraft.setBuno(Objects.requireNonNull(Integer.parseInt(params[1]), "Aircraft Buno cannot be null"));
        } catch (NumberFormatException ex) {
            System.out.println("A number value must be entered for the Buno");
        }
    }

    @Override
    public void delete(AircraftEntity aircraft) {
        aircraftList.remove(aircraft);
    }
}
