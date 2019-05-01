package com.CarRental.repositories.impl;

import com.CarRental.domain.Contact;
import com.CarRental.repositories.ContactRepository;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepositoryImpl repository = null;
    private Set<Contact> contact;

    private ContactRepositoryImpl(){
        this.contact = new HashSet<>();
    }

    private Contact findContact(String contactId) {
        return this.contact.stream()
                .filter(contact -> contact.getContactId().trim().equals(contactId))
                .findAny()
                .orElse(null);
    }

    public static ContactRepositoryImpl getRepository(){
        if (repository == null) repository = new ContactRepositoryImpl();
        return repository;
    }


    public Contact create(Contact contact){
        this.contact.add(contact);
        return contact;
    }

    public Contact read(final String contactId){
        Contact contact = findContact(contactId);
        return contact;
    }

    public void delete(String contactId) {
        Contact contact = findContact(contactId);
        if (contact != null) this.contact.remove(contact);
    }

    public Contact update(Contact contact){
        Contact toDelete = findContact(contact.getContactId());
        if(toDelete != null) {
            this.contact.remove(toDelete);
            return create(contact);
        }
        return null;
    }


    public Set<Contact> getAll(){
        return this.contact;
    }
}
