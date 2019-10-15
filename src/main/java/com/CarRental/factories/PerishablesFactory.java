package com.CarRental.factories;

import com.CarRental.domain.Perishables;

public class PerishablesFactory {

    public static Perishables buildPerishables(Integer perishablesId, String perishableName, String perishableExpiryDate, String perishableQuantity)
    {
        return new Perishables.Builder()
                .perishablesId(perishablesId)
                .perishableName(perishableName)
                .perishableExpiryDate(perishableExpiryDate)
                .perishableQuantity(perishableQuantity)
                .build();
    }
}
