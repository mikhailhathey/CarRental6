package com.CarRental.service;

import com.CarRental.domain.StaffType;

import java.util.Set;

public interface StaffTypeService extends CrudService<StaffType, String>{
    Set<StaffType> getAll();
}
