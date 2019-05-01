package com.CarRental.factories;

import com.CarRental.domain.Contact;

public class ContactFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static Contact buildContact(String contactId, String contactCell, String contactHome, String contactEmail)
    {
        Contact contact = new Contact.Builder()
                .contactId(contactId)
                .contactCell(contactCell)
                .contactHome(contactHome)
                .contactEmail(contactEmail)
                .build();
        return contact;
    }
}
