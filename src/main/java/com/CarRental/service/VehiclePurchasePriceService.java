package com.CarRental.service;

import com.CarRental.domain.VehiclePurchasePrice;

import java.util.List;

public interface VehiclePurchasePriceService extends IService<VehiclePurchasePrice, String>{
    List<VehiclePurchasePrice> getAll();
}
