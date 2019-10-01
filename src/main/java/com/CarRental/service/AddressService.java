package com.CarRental.service;

import com.CarRental.domain.Address;

import java.util.List;

public interface AddressService extends IService<Address, String> {
    List<Address> getAll();
}
