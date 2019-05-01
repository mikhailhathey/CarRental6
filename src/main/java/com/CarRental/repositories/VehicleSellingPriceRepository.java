package com.CarRental.repositories;

import com.CarRental.domain.VehicleSellingPrice;

import java.util.Set;


public interface VehicleSellingPriceRepository extends CrudRepository<VehicleSellingPrice, String> {

    Set<VehicleSellingPrice> getAll();
}
