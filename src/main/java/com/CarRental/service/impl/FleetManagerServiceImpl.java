package com.CarRental.service.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.repositories.FleetManagerRepository;
import com.CarRental.repositories.impl.FleetManagerRepositoryImpl;
import com.CarRental.service.FleetManagerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FleetManagerServiceImpl implements FleetManagerService {

    private static FleetManagerServiceImpl service = null;
    private FleetManagerRepository repository;

    private FleetManagerServiceImpl() {
        this.repository = FleetManagerRepositoryImpl.getRepository();
    }

    public static FleetManagerServiceImpl getService(){
        if (service == null) service = new FleetManagerServiceImpl();
        return service;
    }

    @Override
    public FleetManager create(FleetManager fleetManager) {
        return this.repository.create(fleetManager);
    }

    @Override
    public FleetManager update(FleetManager fleetManager) {
        return this.repository.update(fleetManager);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public FleetManager read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<FleetManager> getAll() {
        return this.repository.getAll();
    }
}
