package com.CarRental.service.impl;

import com.CarRental.domain.Car;
import com.CarRental.repositories.CarRepository;
import com.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CarServiceImpl")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car create(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public Car read(String carId) {
        Optional<Car> byId = this.carRepository.findById(carId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Car update(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public void delete(String carId) {
        this.carRepository.deleteById(carId);
    }
}
