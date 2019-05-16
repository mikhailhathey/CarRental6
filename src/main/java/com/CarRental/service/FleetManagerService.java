package com.CarRental.service;

import com.CarRental.domain.FleetManager;

import java.util.Set;

public interface FleetManagerService extends CrudService<FleetManager, String>{
    Set<FleetManager> getAll();
}
