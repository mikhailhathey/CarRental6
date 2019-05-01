package com.CarRental.repositories;

import com.CarRental.domain.FleetManager;

import java.util.Set;


public interface FleetManagerRepository extends CrudRepository<FleetManager, String> {

    Set<FleetManager> getAll();
}
