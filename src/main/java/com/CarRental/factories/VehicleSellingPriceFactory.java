package com.CarRental.factories;

import com.CarRental.domain.Address;

public class AddressFactory {

    public static Address buildAddress(String id, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        Address address = new Address.Builder()
                .id(id)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return address;
    }
}
