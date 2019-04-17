package com.CarRental.factories;

import com.CarRental.domain.Contact;

public class ContactFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static Contact buildContact(String id, String cell, String home, String email)
    {
        Contact contact = new Contact.Builder()
                .id(id)
                .cell(cell)
                .home(home)
                .email(email)
                .build();
        return contact;
    }
}
