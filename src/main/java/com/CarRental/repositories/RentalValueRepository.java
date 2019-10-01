package com.CarRental.repositories;

import com.CarRental.domain.RentalValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalValueRepository extends JpaRepository<RentalValue, String> {

    //Set<RentalValue> getAll();
}
