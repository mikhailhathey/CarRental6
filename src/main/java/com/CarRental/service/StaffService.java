package com.CarRental.service;

import com.CarRental.domain.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService extends IService<Staff, String>{
    List<Staff> getAll();
}
