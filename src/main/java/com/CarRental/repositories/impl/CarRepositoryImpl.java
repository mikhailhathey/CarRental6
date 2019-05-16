package com.CarRental.repositories.impl;

import com.CarRental.domain.Car;
import com.CarRental.repositories.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private static CarRepositoryImpl repository = null;
    private Set<Car> car;

    private CarRepositoryImpl(){
        this.car = new HashSet<>();
    }

    private Car findCar(String carId) {
        return this.car.stream()
                .filter(car -> car.getCarId().trim().equals(carId))
                .findAny()
                .orElse(null);
    }

    public static CarRepositoryImpl getRepository(){
        if (repository == null) repository = new CarRepositoryImpl();
        return repository;
    }


    public Car create(Car car){
        this.car.add(car);
        return car;
    }

    public Car read(final String carId){
        Car car = findCar(carId);
        return car;
    }

    public void delete(String carId) {
        Car car = findCar(carId);
        if (car != null) this.car.remove(car);
    }

    public Car update(Car car){
        Car toDelete = findCar(car.getCarId());
        if(toDelete != null) {
            this.car.remove(toDelete);
            return create(car);
        }
        return null;
    }


    public Set<Car> getAll(){
        return this.car;
    }
}
