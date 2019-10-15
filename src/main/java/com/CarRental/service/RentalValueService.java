package com.CarRental.service;

import com.CarRental.domain.RentalValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalValueService extends IService<RentalValue, String>{
    List<RentalValue> getAll();
}
