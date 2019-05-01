package com.CarRental.repositories;

import com.CarRental.domain.VehiclePurchasePrice;

import java.util.Set;


public interface VehiclePurchasePriceRepository extends CrudRepository<VehiclePurchasePrice, String> {

    Set<VehiclePurchasePrice> getAll();
}
