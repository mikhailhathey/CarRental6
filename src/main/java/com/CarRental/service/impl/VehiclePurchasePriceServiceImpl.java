package com.CarRental.service.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.repositories.VehiclePurchasePriceRepository;
import com.CarRental.repositories.impl.VehiclePurchasePriceRepositoryImpl;
import com.CarRental.service.VehiclePurchasePriceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VehiclePurchasePriceServiceImpl implements VehiclePurchasePriceService {

    private static VehiclePurchasePriceServiceImpl service = null;
    private VehiclePurchasePriceRepository repository;

    private VehiclePurchasePriceServiceImpl() {
        this.repository = VehiclePurchasePriceRepositoryImpl.getRepository();
    }

    public static VehiclePurchasePriceServiceImpl getService(){
        if (service == null) service = new VehiclePurchasePriceServiceImpl();
        return service;
    }

    @Override
    public VehiclePurchasePrice create(VehiclePurchasePrice vehiclePurchasePrice) {
        return this.repository.create(vehiclePurchasePrice);
    }

    @Override
    public VehiclePurchasePrice update(VehiclePurchasePrice vehiclePurchasePrice) {
        return this.repository.update(vehiclePurchasePrice);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public VehiclePurchasePrice read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<VehiclePurchasePrice> getAll() {
        return this.repository.getAll();
    }
}
