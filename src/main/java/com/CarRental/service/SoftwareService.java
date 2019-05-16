package com.CarRental.service;

import com.CarRental.domain.Software;

import java.util.Set;

public interface SoftwareService extends CrudService<Software, String>{
    Set<Software> getAll();
}
