package com.CarRental.service.impl;

import com.CarRental.domain.Address;
import com.CarRental.repositories.AddressRepository;
import com.CarRental.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address create(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Address read(String addressId) {
        Optional<Address> byId = this.addressRepository.findById(addressId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Address update(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public void delete(String addressId) {
        this.addressRepository.deleteById(addressId);
    }
}
