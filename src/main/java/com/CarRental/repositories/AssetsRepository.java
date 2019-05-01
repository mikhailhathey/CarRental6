package com.CarRental.repositories;

import com.CarRental.domain.Assets;

import java.util.Set;


public interface AssetsRepository extends CrudRepository<Assets, String> {

    Set<Assets> getAll();
    //public List<Assets> findByAge(int age);
    //public List<Assets> findById(String id);

}
