package com.CarRental.service;

import com.CarRental.domain.Staff;

import java.util.Set;

public interface StaffService extends CrudService<Staff, String>{
    Set<Staff> getAll();
}
