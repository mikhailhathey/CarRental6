package com.CarRental.service;

import com.CarRental.domain.Contact;

import java.util.Set;

public interface ContactService extends CrudService<Contact, String>{
    Set<Contact> getAll();
}
