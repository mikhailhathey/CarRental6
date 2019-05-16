package com.CarRental.service;

import com.CarRental.domain.Infrastructure;

import java.util.Set;

public interface InfrastructureService extends CrudService<Infrastructure, String>{
    Set<Infrastructure> getAll();
}
