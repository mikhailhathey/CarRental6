package com.CarRental.service;

import com.CarRental.domain.RentalTerm;

import java.util.Set;

public interface RentalTermService extends CrudService<RentalTerm, String>{
    Set<RentalTerm> getAll();
}
