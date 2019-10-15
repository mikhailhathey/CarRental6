package com.CarRental.repositories;

import com.CarRental.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    //Optional<Car> findById(Integer carId);

    //void deleteById(Integer carId);

    //Set<Car> getAll();
    //public List<Car> findByAge(int age);
    //public List<Car> findById(String id);

}
