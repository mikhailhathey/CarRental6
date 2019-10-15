package com.CarRental.service;

import com.CarRental.domain.VehiclePurchasePrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiclePurchasePriceService extends IService<VehiclePurchasePrice, String>{
    List<VehiclePurchasePrice> getAll();
}
