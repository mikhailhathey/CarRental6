package com.CarRental.service;

import com.CarRental.domain.Infrastructure;

import java.util.List;

public interface InfrastructureService extends IService<Infrastructure, String>{
    List<Infrastructure> getAll();
}
