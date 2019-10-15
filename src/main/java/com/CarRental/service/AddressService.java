package com.CarRental.service;

import com.CarRental.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService extends IService<Address, String> {
    List<Address> getAll();
}
