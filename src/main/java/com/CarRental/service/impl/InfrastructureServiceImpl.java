package com.CarRental.service.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.repositories.InfrastructureRepository;
import com.CarRental.service.InfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("InfrastructureServiceImpl")
public class InfrastructureServiceImpl implements InfrastructureService {

    @Autowired
    private InfrastructureRepository infrastructureRepository;

    @Override
    public List<Infrastructure> getAll() {
        return this.infrastructureRepository.findAll();
    }

    @Override
    public Infrastructure create(Infrastructure infrastructure) {
        return this.infrastructureRepository.save(infrastructure);
    }

    @Override
    public Infrastructure read(Integer infrastructureId) {
        Optional<Infrastructure> byId = this.infrastructureRepository.findById(String.valueOf(infrastructureId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Infrastructure update(Infrastructure infrastructure) {
        return this.infrastructureRepository.save(infrastructure);
    }

    @Override
    public void delete(Integer infrastructureId) {
        this.infrastructureRepository.deleteById(String.valueOf(infrastructureId));
    }
}
