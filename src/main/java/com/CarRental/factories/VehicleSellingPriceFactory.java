package com.CarRental.factories;

import com.CarRental.domain.VehicleSellingPrice;

public class VehicleSellingPriceFactory {

    public static VehicleSellingPrice buildVehicleSellingPrice(String vehicleSellingPriceId, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        VehicleSellingPrice vehicleSellingPriceId = new VehicleSellingPrice.Builder()
                .vehicleSellingPriceId(vehicleSellingPriceId)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return vehicleSellingPriceId;
    }
}
