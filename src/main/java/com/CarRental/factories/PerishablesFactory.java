package com.CarRental.factories;

import com.CarRental.domain.RentalTerm;

public class RentalTermFactory {

    public static RentalTerm buildRentalTerm(String rentalId, String rentalNumber, String rentalClass, String rentalDays, String rentalContact, String rentalBranch)
    {
        RentalTerm rentalTerm = new RentalTerm.Builder()
                .rentalId(rentalId)
                .rentalNumber(rentalNumber)
                .rentalClass(rentalClass)
                .rentalDays(rentalDays)
                .rentalContact(rentalContact)
                .rentalBranch(rentalBranch)
                .build();
        return rentalTerm;
    }
}