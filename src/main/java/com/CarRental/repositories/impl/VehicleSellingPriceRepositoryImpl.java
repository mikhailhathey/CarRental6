package com.CarRental.repositories.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.repositories.VehicleSellingPriceRepository;

import java.util.HashSet;
import java.util.Set;

public class VehicleSellingPriceRepositoryImpl implements VehicleSellingPriceRepository {

    private static VehicleSellingPriceRepositoryImpl repository = null;
    private Set<VehicleSellingPrice> vehicleSellingPrice;

    private VehicleSellingPriceRepositoryImpl(){
        this.vehicleSellingPrice = new HashSet<>();
    }

    private VehicleSellingPrice findVehicleSellingPrice(String vehicleSellingPriceId) {
        return this.vehicleSellingPrice.stream()
                .filter(vehicleSellingPrice -> vehicleSellingPrice.getVehicleSellingPriceId().trim().equals(vehicleSellingPriceId))
                .findAny()
                .orElse(null);
    }

    public static VehicleSellingPriceRepositoryImpl getRepository(){
        if (repository == null) repository = new VehicleSellingPriceRepositoryImpl();
        return repository;
    }


    public VehicleSellingPrice create(VehicleSellingPrice vehicleSellingPrice){
        this.vehicleSellingPrice.add(vehicleSellingPrice);
        return vehicleSellingPrice;
    }

    public VehicleSellingPrice read(final String vehicleSellingPriceId){
        VehicleSellingPrice vehicleSellingPrice = findVehicleSellingPrice(vehicleSellingPriceId);
        return vehicleSellingPrice;
    }

    public void delete(String vehicleSellingPriceId) {
        VehicleSellingPrice vehicleSellingPrice = findVehicleSellingPrice(vehicleSellingPriceId);
        if (vehicleSellingPrice != null) this.vehicleSellingPrice.remove(vehicleSellingPrice);
    }

    public VehicleSellingPrice update(VehicleSellingPrice vehicleSellingPrice){
        VehicleSellingPrice toDelete = findVehicleSellingPrice(vehicleSellingPrice.getVehicleSellingPriceId());
        if(toDelete != null) {
            this.vehicleSellingPrice.remove(toDelete);
            return create(vehicleSellingPrice);
        }
        return null;
    }


    public Set<VehicleSellingPrice> getAll(){
        return this.vehicleSellingPrice;
    }
}
