package com.CarRental.service.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.repositories.HardwareRepository;
import com.CarRental.repositories.impl.HardwareRepositoryImpl;
import com.CarRental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("HardwareServiceImpl")
public class HardwareServiceImpl implements HardwareService {
    @Autowired

    private static HardwareServiceImpl service = null;
    private HardwareRepository repository;

    private HardwareServiceImpl() {
        this.repository = HardwareRepositoryImpl.getRepository();
    }

    public static HardwareServiceImpl getService(){
        if (service == null) service = new HardwareServiceImpl();
        return service;
    }

    @Override
    public Hardware create(Hardware hardware) {
        return this.repository.create(hardware);
    }

    @Override
    public Hardware update(Hardware hardware) {
        return this.repository.update(hardware);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Hardware read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Hardware> getAll() {
        return this.repository.getAll();
    }
}
