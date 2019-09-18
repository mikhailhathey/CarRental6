package com.CarRental.repositories.impl;

import com.CarRental.domain.Address;
import com.CarRental.repositories.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl repository = null;
    private Set<Address> address;

    private AddressRepositoryImpl(){
        this.address = new HashSet<>();
    }

    private Address findAddress(String addressId) {
        return this.address.stream()
                .filter(address -> address.getAddressId().trim().equals(addressId))
                .findAny()
                .orElse(null);
    }

    public static AddressRepositoryImpl getRepository(){
        if (repository == null) repository = new AddressRepositoryImpl();
        return repository;
    }


    public Address create(Address address){
        this.address.add(address);
        return address;
    }

    public Address read(final String addressId){
        Address address = findAddress(addressId);
        return address;
    }

    public void delete(String addressId) {
        Address address = findAddress(addressId);
        if (address != null) this.address.remove(address);
    }

    public Address update(Address address){
        Address toDelete = findAddress(address.getAddressId());
        if(toDelete != null) {
            this.address.remove(toDelete);
            return create(address);
        }
        return null;
    }

    @Override
    public Address retrieveByDesc(String addressDesc) {
        return this.address.stream().filter(address -> address.getHouseNumber().equalsIgnoreCase(addressDesc)).findAny().orElse(null);
    }

    public Set<Address> getAll(){
        return this.address;
    }
}

