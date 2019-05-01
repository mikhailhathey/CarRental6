package com.CarRental.repositories;

import com.CarRental.domain.Claims;

import java.util.Set;


public interface ClaimsRepository extends CrudRepository<Claims, String> {

    Set<Claims> getAll();
    //public List<Claims> findByAge(int age);
    //public List<Claims> findById(String id);

}
