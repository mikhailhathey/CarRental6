package com.CarRental.factories;

import com.CarRental.domain.VehiclePurchasePrice;

public class VehiclePurchasePriceFactory {

    public static VehiclePurchasePrice buildVehiclePurchasePrice(String vehiclePurchasePriceId, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        VehiclePurchasePrice vehiclePurchasePrice = new VehiclePurchasePrice.Builder()
                .vehiclePurchasePriceId(vehiclePurchasePriceId)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return vehiclePurchasePrice;
    }
}
