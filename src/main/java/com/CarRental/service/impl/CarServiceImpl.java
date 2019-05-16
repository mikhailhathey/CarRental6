package com.CarRental.service.impl;

import com.CarRental.domain.Car;
import com.CarRental.repositories.CarRepository;
import com.CarRental.repositories.impl.CarRepositoryImpl;
import com.CarRental.service.CarService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private static CarServiceImpl service = null;
    private CarRepository repository;

    private CarServiceImpl() {
        this.repository = CarRepositoryImpl.getRepository();
    }

    public static CarServiceImpl getService(){
        if (service == null) service = new CarServiceImpl();
        return service;
    }

    @Override
    public Car create(Car car) {
        return this.repository.create(car);
    }

    @Override
    public Car update(Car car) {
        return this.repository.update(car);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Car read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Car> getAll() {
        return this.repository.getAll();
    }
}
