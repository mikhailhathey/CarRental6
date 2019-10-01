package com.CarRental.repositories;

import com.CarRental.domain.VehicleSellingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSellingPriceRepository extends JpaRepository<VehicleSellingPrice, String> {

    //Set<VehicleSellingPrice> getAll();
}
