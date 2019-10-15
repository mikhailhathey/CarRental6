package com.CarRental.repositories;

import com.CarRental.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    //Optional<Address> findById(Integer addressId);

    //void deleteById(Integer addressId);

    //Address retrieveByDesc(String addressDesc);

    //public List<Address> findByAge(int age);
    //public List<Address> findById(String id);

}
