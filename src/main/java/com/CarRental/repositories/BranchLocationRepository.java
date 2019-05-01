package com.CarRental.repositories;

import com.CarRental.domain.BranchLocation;

import java.util.Set;


public interface BranchLocationRepository extends CrudRepository<BranchLocation, String> {

    Set<BranchLocation> getAll();
    //public List<BranchLocation> findByAge(int age);
    //public List<BranchLocation> findById(String id);

}
