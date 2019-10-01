package com.CarRental.factories;

import com.CarRental.domain.VehiclePurchasePrice;

public class VehiclePurchasePriceFactory {

    public static VehiclePurchasePrice buildVehiclePurchasePrice(String vehiclePurchasePriceId, String vehicleYearModel, String vehiclePrice)
    {
        return new VehiclePurchasePrice.Builder()
                .vehiclePurchasePriceId(vehiclePurchasePriceId)
                .vehicleYearModel(vehicleYearModel)
                .vehiclePrice(vehiclePrice)
                .build();
    }
}
