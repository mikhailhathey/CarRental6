package com.CarRental.service.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.repositories.PerishablesRepository;
import com.CarRental.repositories.impl.PerishablesRepositoryImpl;
import com.CarRental.service.PerishablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PerishablesServiceImpl")
public class PerishablesServiceImpl implements PerishablesService {
    @Autowired

    private static PerishablesServiceImpl service = null;
    private PerishablesRepository repository;

    private PerishablesServiceImpl() {
        this.repository = PerishablesRepositoryImpl.getRepository();
    }

    public static PerishablesServiceImpl getService(){
        if (service == null) service = new PerishablesServiceImpl();
        return service;
    }

    @Override
    public Perishables create(Perishables perishables) {
        return this.repository.create(perishables);
    }

    @Override
    public Perishables update(Perishables perishables) {
        return this.repository.update(perishables);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Perishables read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Perishables> getAll() {
        return this.repository.getAll();
    }
}
