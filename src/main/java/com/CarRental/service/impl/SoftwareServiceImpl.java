package com.CarRental.service.impl;

import com.CarRental.domain.Software;
import com.CarRental.repositories.SoftwareRepository;
import com.CarRental.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SoftwareServiceImpl")
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    private SoftwareRepository softwareRepository;

    @Override
    public List<Software> getAll() {
        return this.softwareRepository.findAll();
    }

    @Override
    public Software create(Software software) {
        return this.softwareRepository.save(software);
    }

    @Override
    public Software read(Integer softwareId) {
        Optional<Software> byId = this.softwareRepository.findById(String.valueOf(softwareId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Software update(Software software) {
        return this.softwareRepository.save(software);
    }

    @Override
    public void delete(Integer softwareId) {
        this.softwareRepository.deleteById(String.valueOf(softwareId));
    }
}
