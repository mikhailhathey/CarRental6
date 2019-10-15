package com.CarRental.service.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.repositories.VehiclePurchasePriceRepository;
import com.CarRental.service.VehiclePurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("VehiclePurchasePriceServiceImpl")
public class VehiclePurchasePriceServiceImpl implements VehiclePurchasePriceService {

    @Autowired
    private VehiclePurchasePriceRepository vehiclePurchasePriceRepository;

    @Override
    public List<VehiclePurchasePrice> getAll() {
        return this.vehiclePurchasePriceRepository.findAll();
    }

    @Override
    public VehiclePurchasePrice create(VehiclePurchasePrice vehiclePurchasePrice) {
        return this.vehiclePurchasePriceRepository.save(vehiclePurchasePrice);
    }

    @Override
    public VehiclePurchasePrice read(Integer vehiclePurchasePriceId) {
        Optional<VehiclePurchasePrice> byId = this.vehiclePurchasePriceRepository.findById(String.valueOf(vehiclePurchasePriceId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public VehiclePurchasePrice update(VehiclePurchasePrice vehiclePurchasePrice) {
        return this.vehiclePurchasePriceRepository.save(vehiclePurchasePrice);
    }

    @Override
    public void delete(Integer vehiclePurchasePriceId) {
        this.vehiclePurchasePriceRepository.deleteById(String.valueOf(vehiclePurchasePriceId));
    }
}
