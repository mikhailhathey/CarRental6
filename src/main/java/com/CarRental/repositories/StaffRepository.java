package com.CarRental.repositories;

import com.CarRental.domain.Staff;

import java.util.Set;


public interface StaffRepository extends CrudRepository<Staff, String> {

    Set<Staff> getAll();
}
