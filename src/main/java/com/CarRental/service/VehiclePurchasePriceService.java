package com.CarRental.service;

import com.CarRental.domain.VehiclePurchasePrice;

import java.util.Set;

public interface VehiclePurchasePriceService extends CrudService<VehiclePurchasePrice, String>{
    Set<VehiclePurchasePrice> getAll();
}
