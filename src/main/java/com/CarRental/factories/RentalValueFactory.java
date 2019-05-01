package com.CarRental.factories;

import com.CarRental.domain.RentalValue;

public class RentalValueFactory {

    public static RentalValue buildRentalValue(String rentalValueId, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        RentalValue rentalValue = new RentalValue.Builder()
                .rentalValueId(rentalValueId)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return rentalValue;
    }
}
