package com.CarRental.service.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.repositories.RentalTermRepository;
import com.CarRental.service.RentalTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RentalTermServiceImpl")
public class RentalTermServiceImpl implements RentalTermService {

    @Autowired
    private RentalTermRepository rentalTermRepository;

    @Override
    public List<RentalTerm> getAll() {
        return this.rentalTermRepository.findAll();
    }

    @Override
    public RentalTerm create(RentalTerm rentalTerm) {
        return this.rentalTermRepository.save(rentalTerm);
    }

    @Override
    public RentalTerm read(String rentalTermId) {
        Optional<RentalTerm> byId = this.rentalTermRepository.findById(rentalTermId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public RentalTerm update(RentalTerm rentalTerm) {
        return this.rentalTermRepository.save(rentalTerm);
    }

    @Override
    public void delete(String rentalTermId) {
        this.rentalTermRepository.deleteById(rentalTermId);
    }
}
