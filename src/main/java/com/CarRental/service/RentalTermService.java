package com.CarRental.service;

import com.CarRental.domain.RentalTerm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface RentalTermService extends IService<RentalTerm, String>{
    List<RentalTerm> getAll();
}
