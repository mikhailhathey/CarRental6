package com.CarRental.factories;

import com.CarRental.domain.Address;

public class AddressFactory {

    public static Address buildAddress(String addressId, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        Address address = new Address.Builder()
                .addressId(addressId)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return address;
    }

}
