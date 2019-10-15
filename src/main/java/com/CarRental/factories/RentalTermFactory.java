package com.CarRental.factories;

import com.CarRental.domain.RentalTerm;

public class RentalTermFactory {

    public static RentalTerm buildRentalTerm(Integer rentalTermId, String rentalTermNumber, String rentalTermClass, String rentalTermDays, String rentalTermContact, String rentalTermBranch)
    {
        return new RentalTerm.Builder()
                .rentalTermId(rentalTermId)
                .rentalTermNumber(rentalTermNumber)
                .rentalTermClass(rentalTermClass)
                .rentalTermDays(rentalTermDays)
                .rentalTermContact(rentalTermContact)
                .rentalTermBranch(rentalTermBranch)
                .build();
    }
}
