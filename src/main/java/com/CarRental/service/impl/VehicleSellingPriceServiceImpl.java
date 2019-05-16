package com.CarRental.service.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.repositories.VehicleSellingPriceRepository;
import com.CarRental.repositories.impl.VehicleSellingPriceRepositoryImpl;
import com.CarRental.service.VehicleSellingPriceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VehicleSellingPriceServiceImpl implements VehicleSellingPriceService {

    private static VehicleSellingPriceServiceImpl service = null;
    private VehicleSellingPriceRepository repository;

    private VehicleSellingPriceServiceImpl() {
        this.repository = VehicleSellingPriceRepositoryImpl.getRepository();
    }

    public static VehicleSellingPriceServiceImpl getService(){
        if (service == null) service = new VehicleSellingPriceServiceImpl();
        return service;
    }

    @Override
    public VehicleSellingPrice create(VehicleSellingPrice vehicleSellingPrice) {
        return this.repository.create(vehicleSellingPrice);
    }

    @Override
    public VehicleSellingPrice update(VehicleSellingPrice vehicleSellingPrice) {
        return this.repository.update(vehicleSellingPrice);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public VehicleSellingPrice read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<VehicleSellingPrice> getAll() {
        return this.repository.getAll();
    }
}
