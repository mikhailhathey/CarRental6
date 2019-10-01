package com.CarRental.service.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.repositories.RentalValueRepository;
import com.CarRental.service.RentalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RentalValueServiceImpl")
public class RentalValueServiceImpl implements RentalValueService {

    @Autowired
    private RentalValueRepository rentalValueRepository;

    @Override
    public List<RentalValue> getAll() {
        return this.rentalValueRepository.findAll();
    }

    @Override
    public RentalValue create(RentalValue rentalValue) {
        return this.rentalValueRepository.save(rentalValue);
    }

    @Override
    public RentalValue read(String rentalValueId) {
        Optional<RentalValue> byId = this.rentalValueRepository.findById(rentalValueId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public RentalValue update(RentalValue rentalValue) {
        return this.rentalValueRepository.save(rentalValue);
    }

    @Override
    public void delete(String rentalValueId) {
        this.rentalValueRepository.deleteById(rentalValueId);
    }
}
