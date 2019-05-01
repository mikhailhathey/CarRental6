package com.CarRental.factories;

import com.CarRental.domain.Client;

public class ClientFactory {

    public static Client buildClient(String clientId, String clientCell, String clientName, String clientEmail, String clientWebsite, String clientAddress)
    {
        Client client = new Client.Builder()
                .clientId(clientId)
                .clientCell(clientCell)
                .clientName(clientName)
                .clientEmail(clientEmail)
                .clientWebsite(clientWebsite)
                .clientAddress(clientAddress)
                .build();
        return client;
    }
}
