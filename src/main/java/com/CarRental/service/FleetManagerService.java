package com.CarRental.service;

import com.CarRental.domain.FleetManager;

import java.util.List;

public interface FleetManagerService extends IService<FleetManager, String>{
    List<FleetManager> getAll();
}
