package com.CarRental.service.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.repositories.PerishablesRepository;
import com.CarRental.service.PerishablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PerishablesServiceImpl")
public class PerishablesServiceImpl implements PerishablesService {

    @Autowired
    private PerishablesRepository perishablesRepository;

    @Override
    public List<Perishables> getAll() {
        return this.perishablesRepository.findAll();
    }

    @Override
    public Perishables create(Perishables perishables) {
        return this.perishablesRepository.save(perishables);
    }

    @Override
    public Perishables read(String perishablesId) {
        Optional<Perishables> byId = this.perishablesRepository.findById(perishablesId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Perishables update(Perishables perishables) {
        return this.perishablesRepository.save(perishables);
    }

    @Override
    public void delete(String perishablesId) {
        this.perishablesRepository.deleteById(perishablesId);
    }
}
