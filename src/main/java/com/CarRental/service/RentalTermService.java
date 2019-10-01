package com.CarRental.service;

import com.CarRental.domain.RentalTerm;

import java.util.List;
import java.util.Set;

public interface RentalTermService extends IService<RentalTerm, String>{
    List<RentalTerm> getAll();
}
