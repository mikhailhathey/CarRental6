package com.CarRental.service;

import com.CarRental.domain.Staff;

import java.util.List;

public interface StaffService extends IService<Staff, String>{
    List<Staff> getAll();
}
