package com.CarRental.service.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.repositories.FleetManagerRepository;
import com.CarRental.service.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FleetManagerServiceImpl")
public class FleetManagerServiceImpl implements FleetManagerService {

    @Autowired
    private FleetManagerRepository fleetManagerRepository;

    @Override
    public List<FleetManager> getAll() {
        return this.fleetManagerRepository.findAll();
    }

    @Override
    public FleetManager create(FleetManager fleetManager) {
        return this.fleetManagerRepository.save(fleetManager);
    }

    @Override
    public FleetManager read(String fleetManagerId) {
        Optional<FleetManager> byId = this.fleetManagerRepository.findById(fleetManagerId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public FleetManager update(FleetManager fleetManager) {
        return this.fleetManagerRepository.save(fleetManager);
    }

    @Override
    public void delete(String fleetManagerId) {
        this.fleetManagerRepository.deleteById(fleetManagerId);
    }
}
