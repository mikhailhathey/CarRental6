package com.CarRental.service;

import com.CarRental.domain.Car;

import java.util.Set;

public interface CarService extends CrudService<Car, String>{
    Set<Car> getAll();
}
