package com.CarRental.service.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.repositories.HardwareRepository;
import com.CarRental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("HardwareServiceImpl")
public class HardwareServiceImpl implements HardwareService {

    @Autowired
    private HardwareRepository hardwareRepository;

    @Override
    public List<Hardware> getAll() {
        return this.hardwareRepository.findAll();
    }

    @Override
    public Hardware create(Hardware hardware) {
        return this.hardwareRepository.save(hardware);
    }

    @Override
    public Hardware read(String hardwareId) {
        Optional<Hardware> byId = this.hardwareRepository.findById(hardwareId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Hardware update(Hardware hardware) {
        return this.hardwareRepository.save(hardware);
    }

    @Override
    public void delete(String hardwareId) {
        this.hardwareRepository.deleteById(hardwareId);
    }
}
