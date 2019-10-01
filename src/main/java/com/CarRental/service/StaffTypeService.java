package com.CarRental.service;

import com.CarRental.domain.StaffType;

import java.util.List;

public interface StaffTypeService extends IService<StaffType, String>{
    List<StaffType> getAll();
}
