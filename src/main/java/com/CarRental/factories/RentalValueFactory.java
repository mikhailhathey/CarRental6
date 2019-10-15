package com.CarRental.factories;

import com.CarRental.domain.RentalValue;

public class RentalValueFactory {

    public static RentalValue buildRentalValue(Integer rentalValueId, String rentalValueClass, String rentalValueAmount)
    {
        return new RentalValue.Builder()
                .rentalValueId(rentalValueId)
                .rentalValueClass(rentalValueClass)
                .rentalValueAmount(rentalValueAmount)
                .build();
    }
}
