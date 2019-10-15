package com.CarRental.service;

import com.CarRental.domain.VehicleSellingPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleSellingPriceService extends IService<VehicleSellingPrice, String>{
    List<VehicleSellingPrice> getAll();
}
