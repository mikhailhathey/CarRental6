package com.CarRental.service;

import com.CarRental.domain.Car;

import java.util.List;

public interface CarService extends IService<Car, String>{
    List<Car> getAll();
}
