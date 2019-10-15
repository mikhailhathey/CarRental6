package com.CarRental.repositories;

import com.CarRental.domain.VehicleSellingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleSellingPriceRepository extends JpaRepository<VehicleSellingPrice, String> {
    //Optional<VehicleSellingPrice> findById(Integer vehicleSellingPriceId);

    //void deleteById(Integer vehicleSellingPriceId);

    //Set<VehicleSellingPrice> getAll();
}
