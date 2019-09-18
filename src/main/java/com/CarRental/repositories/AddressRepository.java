package com.CarRental.repositories;

import com.CarRental.domain.Address;

import java.util.Set;


public interface AddressRepository extends CrudRepository<Address, String> {

    Address retrieveByDesc(String addressDesc);
    Set<Address> getAll();
    //public List<Address> findByAge(int age);
    //public List<Address> findById(String id);

}
