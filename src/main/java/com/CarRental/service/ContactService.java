package com.CarRental.service;

import com.CarRental.domain.Contact;

import java.util.List;

public interface ContactService extends IService<Contact, String>{
    List<Contact> getAll();
}
