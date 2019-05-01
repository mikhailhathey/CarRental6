package com.CarRental.factories;

import com.CarRental.domain.Perishables;

public class PerishablesFactory {

    public static Perishables buildPerishables(String perishablesId, String perishableName, String perishableExpiryDate, String perishableQuantity)
    {
        Perishables perishables = new Perishables.Builder()
                .perishablesId(perishablesId)
                .perishableName(perishableName)
                .perishableExpiryDate(perishableExpiryDate)
                .perishableQuantity(perishableQuantity)
                .build();
        return perishables;
    }
}