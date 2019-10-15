package com.CarRental.service;

import com.CarRental.domain.FleetManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FleetManagerService extends IService<FleetManager, String>{
    List<FleetManager> getAll();
}
