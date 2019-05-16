package com.CarRental.service.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.repositories.RentalTermRepository;
import com.CarRental.repositories.impl.RentalTermRepositoryImpl;
import com.CarRental.service.RentalTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RentalTermServiceImpl")
public class RentalTermServiceImpl implements RentalTermService {
    @Autowired

    private static RentalTermServiceImpl service = null;
    private RentalTermRepository repository;

    private RentalTermServiceImpl() {
        this.repository = RentalTermRepositoryImpl.getRepository();
    }

    public static RentalTermServiceImpl getService(){
        if (service == null) service = new RentalTermServiceImpl();
        return service;
    }

    @Override
    public RentalTerm create(RentalTerm rentalTerm) {
        return this.repository.create(rentalTerm);
    }

    @Override
    public RentalTerm update(RentalTerm rentalTerm) {
        return this.repository.update(rentalTerm);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public RentalTerm read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<RentalTerm> getAll() {
        return this.repository.getAll();
    }
}
