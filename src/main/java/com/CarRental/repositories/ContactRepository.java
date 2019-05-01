package com.CarRental.repositories;

import com.CarRental.domain.Contact;

import java.util.Set;


public interface ContactRepository extends CrudRepository<Contact, String> {

    Set<Contact> getAll();
}
