package com.CarRental.service;

import com.CarRental.domain.VehicleSellingPrice;

import java.util.List;

public interface VehicleSellingPriceService extends IService<VehicleSellingPrice, String>{
    List<VehicleSellingPrice> getAll();
}
