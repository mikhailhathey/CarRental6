package com.CarRental.service;

import com.CarRental.domain.RentalValue;

import java.util.List;

public interface RentalValueService extends IService<RentalValue, String>{
    List<RentalValue> getAll();
}
