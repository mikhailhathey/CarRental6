package com.CarRental.service.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.repositories.VehicleSellingPriceRepository;
import com.CarRental.service.VehicleSellingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("VehicleSellingPriceServiceImpl")
public class VehicleSellingPriceServiceImpl implements VehicleSellingPriceService {

    @Autowired
    private VehicleSellingPriceRepository vehicleSellingPriceRepository;

    @Override
    public List<VehicleSellingPrice> getAll() {
        return this.vehicleSellingPriceRepository.findAll();
    }

    @Override
    public VehicleSellingPrice create(VehicleSellingPrice vehicleSellingPrice) {
        return this.vehicleSellingPriceRepository.save(vehicleSellingPrice);
    }

    @Override
    public VehicleSellingPrice read(String vehicleSellingPriceId) {
        Optional<VehicleSellingPrice> byId = this.vehicleSellingPriceRepository.findById(vehicleSellingPriceId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public VehicleSellingPrice update(VehicleSellingPrice vehicleSellingPrice) {
        return this.vehicleSellingPriceRepository.save(vehicleSellingPrice);
    }

    @Override
    public void delete(String vehicleSellingPriceId) {
        this.vehicleSellingPriceRepository.deleteById(vehicleSellingPriceId);
    }
}
