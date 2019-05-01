package com.CarRental.repositories;

import com.CarRental.domain.Region;

import java.util.Set;


public interface RegionRepository extends CrudRepository<Region, String> {

    Set<Region> getAll();
}
