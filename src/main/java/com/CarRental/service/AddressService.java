package com.CarRental.service;

import com.CarRental.domain.Address;

import java.util.Set;

public interface AddressService extends CrudService<Address, String>{
    Address retrieveByDesc(String addressDesc);
    Set<Address> getAll();
}