package com.CarRental.service;

import com.CarRental.domain.Admin;

import java.util.List;

public interface AdminService extends IService<Admin, String>{
    List<Admin> getAll();
}
