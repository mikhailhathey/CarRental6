package com.CarRental.service;

import com.CarRental.domain.VehicleSellingPrice;

import java.util.Set;

public interface VehicleSellingPriceService extends CrudService<VehicleSellingPrice, String>{
    Set<VehicleSellingPrice> getAll();
}
