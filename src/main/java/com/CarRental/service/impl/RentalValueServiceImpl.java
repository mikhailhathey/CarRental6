package com.CarRental.service.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.repositories.RentalValueRepository;
import com.CarRental.repositories.impl.RentalValueRepositoryImpl;
import com.CarRental.service.RentalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RentalValueServiceImpl")
public class RentalValueServiceImpl implements RentalValueService {
    @Autowired

    private static RentalValueServiceImpl service = null;
    private RentalValueRepository repository;

    private RentalValueServiceImpl() {
        this.repository = RentalValueRepositoryImpl.getRepository();
    }

    public static RentalValueServiceImpl getService(){
        if (service == null) service = new RentalValueServiceImpl();
        return service;
    }

    @Override
    public RentalValue create(RentalValue rentalValue) {
        return this.repository.create(rentalValue);
    }

    @Override
    public RentalValue update(RentalValue rentalValue) {
        return this.repository.update(rentalValue);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public RentalValue read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<RentalValue> getAll() {
        return this.repository.getAll();
    }
}
