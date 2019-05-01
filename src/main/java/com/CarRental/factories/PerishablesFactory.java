package com.CarRental.factories;

import com.CarRental.domain.Perishables;

public class PerishablesFactory {

    public static Perishables buildPerishables(String perishablesId, String perishablesNumber, String perishablesClass, String perishablesDays, String perishablesContact, String perishablesBranch)
    {
        Perishables perishables = new Perishables.Builder()
                .perishablesId(perishablesId)
                .perishablesNumber(perishablesNumber)
                .perishablesClass(perishablesClass)
                .perishablesDays(perishablesDays)
                .perishablesContact(perishablesContact)
                .perishablesBranch(perishablesBranch)
                .build();
        return perishables;
    }
}