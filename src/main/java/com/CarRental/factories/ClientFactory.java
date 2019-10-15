package com.CarRental.factories;

import com.CarRental.domain.Client;

public class ClientFactory {

    public static Client buildClient(Integer clientId, String clientCell, String clientName, String clientEmail, String clientWebsite, String clientAddress)
    {
        return new Client.Builder()
                .clientId(clientId)
                .clientCell(clientCell)
                .clientName(clientName)
                .clientEmail(clientEmail)
                .clientWebsite(clientWebsite)
                .clientAddress(clientAddress)
                .build();
    }
}
