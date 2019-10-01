package com.CarRental.repositories;

import com.CarRental.domain.VehiclePurchasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclePurchasePriceRepository extends JpaRepository<VehiclePurchasePrice, String> {

    //Set<VehiclePurchasePrice> getAll();
}
