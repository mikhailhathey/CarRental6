package com.CarRental.service.impl;

import com.CarRental.domain.Address;
import com.CarRental.repositories.AddressRepository;
import com.CarRental.repositories.impl.AddressRepositoryImpl;
import com.CarRental.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository repository;

    private static AddressServiceImpl service = null;

    private AddressServiceImpl() {
        this.repository = AddressRepositoryImpl.getRepository();
    }

    public static AddressServiceImpl getService(){
        if (service == null) service = new AddressServiceImpl();
        return service;
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }
}
