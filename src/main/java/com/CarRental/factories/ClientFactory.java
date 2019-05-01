package com.CarRental.factories;

import com.CarRental.domain.Client;

public class ClientFactory {

    public static Client buildClient(String id, String houseNumber, String streetName, String suburb, String postalCode, String city)
    {
        Client client = new Client.Builder()
                .clientId(id)
                .houseNumber(houseNumber)
                .streetName(streetName)
                .suburb(suburb)
                .postalCode(postalCode)
                .city(city)
                .build();
        return client;
    }
}
