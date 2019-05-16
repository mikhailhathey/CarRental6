package com.CarRental.service;

import com.CarRental.domain.Admin;

import java.util.Set;

public interface AdminService extends CrudService<Admin, String>{
    Set<Admin> getAll();
}
