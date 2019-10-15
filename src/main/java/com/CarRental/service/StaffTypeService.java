package com.CarRental.service;

import com.CarRental.domain.StaffType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffTypeService extends IService<StaffType, String>{
    List<StaffType> getAll();
}
