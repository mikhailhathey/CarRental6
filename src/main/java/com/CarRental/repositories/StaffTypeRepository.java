package com.CarRental.repositories;

import com.CarRental.domain.StaffType;

import java.util.Set;


public interface StaffTypeRepository extends CrudRepository<StaffType, String> {

    Set<StaffType> getAll();
}
