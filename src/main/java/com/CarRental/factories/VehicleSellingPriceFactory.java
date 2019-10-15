package com.CarRental.factories;

import com.CarRental.domain.VehicleSellingPrice;

public class VehicleSellingPriceFactory {

    public static VehicleSellingPrice buildVehicleSellingPrice(Integer vehicleSellingPriceId, String vehicleYearModel, String vehiclePrice)
    {
        return new VehicleSellingPrice.Builder()
                .vehicleSellingPriceId(vehicleSellingPriceId)
                .vehicleYearModel(vehicleYearModel)
                .vehiclePrice(vehiclePrice)
                .build();
    }
}
