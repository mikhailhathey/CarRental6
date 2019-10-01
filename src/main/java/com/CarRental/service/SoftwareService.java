package com.CarRental.service;

import com.CarRental.domain.Software;

import java.util.List;

public interface SoftwareService extends IService<Software, String>{
    List<Software> getAll();
}
