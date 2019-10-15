package com.CarRental.service;

import com.CarRental.domain.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService extends IService<Car, String>{
    List<Car> getAll();
}
