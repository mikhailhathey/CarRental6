package com.CarRental.repositories.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.repositories.VehiclePurchasePriceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class VehiclePurchasePriceRepositoryImpl implements VehiclePurchasePriceRepository {

    private static VehiclePurchasePriceRepositoryImpl repository = null;
    private Set<VehiclePurchasePrice> vehiclePurchasePrice;

    private VehiclePurchasePriceRepositoryImpl(){
        this.vehiclePurchasePrice = new HashSet<>();
    }

    private VehiclePurchasePrice findVehiclePurchasePrice(String vehiclePurchasePriceId) {
        return this.vehiclePurchasePrice.stream()
                .filter(vehiclePurchasePrice -> vehiclePurchasePrice.getVehiclePurchasePriceId().trim().equals(vehiclePurchasePriceId))
                .findAny()
                .orElse(null);
    }

    public static VehiclePurchasePriceRepositoryImpl getRepository(){
        if (repository == null) repository = new VehiclePurchasePriceRepositoryImpl();
        return repository;
    }


    public VehiclePurchasePrice create(VehiclePurchasePrice vehiclePurchasePrice){
        this.vehiclePurchasePrice.add(vehiclePurchasePrice);
        return vehiclePurchasePrice;
    }

    public VehiclePurchasePrice read(final String vehiclePurchasePriceId){
        VehiclePurchasePrice vehiclePurchasePrice = findVehiclePurchasePrice(vehiclePurchasePriceId);
        return vehiclePurchasePrice;
    }

    public void delete(String vehiclePurchasePriceId) {
        VehiclePurchasePrice vehiclePurchasePrice = findVehiclePurchasePrice(vehiclePurchasePriceId);
        if (vehiclePurchasePrice != null) this.vehiclePurchasePrice.remove(vehiclePurchasePrice);
    }

    public VehiclePurchasePrice update(VehiclePurchasePrice vehiclePurchasePrice){
        VehiclePurchasePrice toDelete = findVehiclePurchasePrice(vehiclePurchasePrice.getVehiclePurchasePriceId());
        if(toDelete != null) {
            this.vehiclePurchasePrice.remove(toDelete);
            return create(vehiclePurchasePrice);
        }
        return null;
    }


    public Set<VehiclePurchasePrice> getAll(){
        return this.vehiclePurchasePrice;
    }
}
