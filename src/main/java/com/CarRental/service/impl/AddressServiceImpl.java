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
    private AddressRepository addressRepository;

    private static AddressServiceImpl service = null;

    private AddressServiceImpl() {
        this.addressRepository = AddressRepositoryImpl.getRepository();
    }

    public static AddressServiceImpl getService(){
        if (service == null) service = new AddressServiceImpl();
        return service;
    }

    @Override
    public Address create(Address address) {
        return this.addressRepository.create(address);
    }

    @Override
    public Address update(Address address) {
        return this.addressRepository.update(address);
    }

    @Override
    public void delete(String s) {
        this.addressRepository.delete(s);
    }

    @Override
    public Address read(String s) {
        return this.addressRepository.read(s);
    }

    @Override
    public Address retrieveByDesc(String addressDesc) {
        return this.addressRepository.retrieveByDesc(addressDesc);
    }

    @Override
    public Set<Address> getAll() {
        return this.addressRepository.getAll();
    }
}
