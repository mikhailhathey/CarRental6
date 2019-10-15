package com.CarRental.repositories;

import com.CarRental.domain.RentalValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalValueRepository extends JpaRepository<RentalValue, String> {
    //Optional<RentalValue> findById(Integer rentalValueId);

    //void deleteById(Integer rentalValueId);

    //Set<RentalValue> getAll();
}
