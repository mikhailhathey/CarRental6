package com.CarRental.repositories;

import com.CarRental.domain.RentalValue;

import java.util.Set;


public interface RentalValueRepository extends CrudRepository<RentalValue, String> {

    Set<RentalValue> getAll();
}
