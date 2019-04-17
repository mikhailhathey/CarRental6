package com.CarRental.factories;

import com.CarRental.domain.Contact;

public class AssetsFactory {

    //Changes to be made, in future iteration remove String assetId and have the String assetId generated.
    public static Contact buildContact(String assetId, String assetName, String assetLocation, String assetType)
    {
        Contact contact = new Contact.Builder()
                .assetId(assetId)
                .assetName(assetName)
                .assetLocation(assetLocation)
                .assetType(assetType)
                .build();
        return contact;
    }
}
