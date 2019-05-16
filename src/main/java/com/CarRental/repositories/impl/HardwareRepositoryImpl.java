package com.CarRental.repositories.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.repositories.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static HardwareRepositoryImpl repository = null;
    private Set<Hardware> hardware;

    private HardwareRepositoryImpl(){
        this.hardware = new HashSet<>();
    }

    private Hardware findHardware(String hardwareId) {
        return this.hardware.stream()
                .filter(hardware -> hardware.getHardwareId().trim().equals(hardwareId))
                .findAny()
                .orElse(null);
    }

    public static HardwareRepositoryImpl getRepository(){
        if (repository == null) repository = new HardwareRepositoryImpl();
        return repository;
    }


    public Hardware create(Hardware hardware){
        this.hardware.add(hardware);
        return hardware;
    }

    public Hardware read(final String hardwareId){
        Hardware hardware = findHardware(hardwareId);
        return hardware;
    }

    public void delete(String hardwareId) {
        Hardware hardware = findHardware(hardwareId);
        if (hardware != null) this.hardware.remove(hardware);
    }

    public Hardware update(Hardware hardware){
        Hardware toDelete = findHardware(hardware.getHardwareId());
        if(toDelete != null) {
            this.hardware.remove(toDelete);
            return create(hardware);
        }
        return null;
    }


    public Set<Hardware> getAll(){
        return this.hardware;
    }
}
