package com.CarRental.repositories.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.repositories.FleetManagerRepository;

import java.util.HashSet;
import java.util.Set;

public class FleetManagerRepositoryImpl implements FleetManagerRepository {

    private static FleetManagerRepositoryImpl repository = null;
    private Set<FleetManager> fleetManager;

    private FleetManagerRepositoryImpl(){
        this.fleetManager = new HashSet<>();
    }

    private FleetManager findFleetManager(String fleetManagerId) {
        return this.fleetManager.stream()
                .filter(fleetManager -> fleetManager.getFleetManagerId().trim().equals(fleetManagerId))
                .findAny()
                .orElse(null);
    }

    public static FleetManagerRepositoryImpl getRepository(){
        if (repository == null) repository = new FleetManagerRepositoryImpl();
        return repository;
    }


    public FleetManager create(FleetManager fleetManager){
        this.fleetManager.add(fleetManager);
        return fleetManager;
    }

    public FleetManager read(final String fleetManagerId){
        FleetManager fleetManager = findFleetManager(fleetManagerId);
        return fleetManager;
    }

    public void delete(String fleetManagerId) {
        FleetManager fleetManager = findFleetManager(fleetManagerId);
        if (fleetManager != null) this.fleetManager.remove(fleetManager);
    }

    public FleetManager update(FleetManager fleetManager){
        FleetManager toDelete = findFleetManager(fleetManager.getFleetManagerId());
        if(toDelete != null) {
            this.fleetManager.remove(toDelete);
            return create(fleetManager);
        }
        return null;
    }


    public Set<FleetManager> getAll(){
        return this.fleetManager;
    }
}
