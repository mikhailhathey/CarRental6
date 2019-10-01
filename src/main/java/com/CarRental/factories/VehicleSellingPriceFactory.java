package com.CarRental.factories;

import com.CarRental.domain.VehicleSellingPrice;

public class VehicleSellingPriceFactory {

    public static VehicleSellingPrice buildVehicleSellingPrice(String vehicleSellingPriceId, String vehicleYearModel, String vehiclePrice)
    {
        return new VehicleSellingPrice.Builder()
                .vehicleSellingPriceId(vehicleSellingPriceId)
                .vehicleYearModel(vehicleYearModel)
                .vehiclePrice(vehiclePrice)
                .build();
    }
}
