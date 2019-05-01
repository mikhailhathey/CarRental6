package com.CarRental.repositories.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.repositories.RentalValueRepository;

import java.util.HashSet;
import java.util.Set;

public class RentalValueRepositoryImpl implements RentalValueRepository {

    private static RentalValueRepositoryImpl repository = null;
    private Set<RentalValue> rentalValue;

    private RentalValueRepositoryImpl(){
        this.rentalValue = new HashSet<>();
    }

    private RentalValue findRentalValue(String rentalValueId) {
        return this.rentalValue.stream()
                .filter(rentalValue -> rentalValue.getRentalValueId().trim().equals(rentalValueId))
                .findAny()
                .orElse(null);
    }

    public static RentalValueRepositoryImpl getRepository(){
        if (repository == null) repository = new RentalValueRepositoryImpl();
        return repository;
    }


    public RentalValue create(RentalValue rentalValue){
        this.rentalValue.add(rentalValue);
        return rentalValue;
    }

    public RentalValue read(final String rentalValueId){
        RentalValue rentalValue = findRentalValue(rentalValueId);
        return rentalValue;
    }

    public void delete(String rentalValueId) {
        RentalValue rentalValue = findRentalValue(rentalValueId);
        if (rentalValue != null) this.rentalValue.remove(rentalValue);
    }

    public RentalValue update(RentalValue rentalValue){
        RentalValue toDelete = findRentalValue(rentalValue.getRentalValueId());
        if(toDelete != null) {
            this.rentalValue.remove(toDelete);
            return create(rentalValue);
        }
        return null;
    }


    public Set<RentalValue> getAll(){
        return this.rentalValue;
    }
}
