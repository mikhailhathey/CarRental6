package com.CarRental.service;

import com.CarRental.domain.RentalValue;

import java.util.Set;

public interface RentalValueService extends CrudService<RentalValue, String>{
    Set<RentalValue> getAll();
}
