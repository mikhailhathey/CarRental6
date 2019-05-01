package com.CarRental.repositories;

import com.CarRental.domain.Car;

import java.util.Set;


public interface CarRepository extends CrudRepository<Car, String> {

    Set<Car> getAll();
    //public List<Car> findByAge(int age);
    //public List<Car> findById(String id);

}
