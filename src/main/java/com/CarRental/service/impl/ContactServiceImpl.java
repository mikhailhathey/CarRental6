package com.CarRental.service.impl;

import com.CarRental.domain.Contact;
import com.CarRental.repositories.ContactRepository;
import com.CarRental.repositories.impl.ContactRepositoryImpl;
import com.CarRental.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static ContactServiceImpl service = null;
    private ContactRepository repository;

    private ContactServiceImpl() {
        this.repository = ContactRepositoryImpl.getRepository();
    }

    public static ContactServiceImpl getService(){
        if (service == null) service = new ContactServiceImpl();
        return service;
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.create(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.update(contact);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Contact read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Contact> getAll() {
        return this.repository.getAll();
    }
}
