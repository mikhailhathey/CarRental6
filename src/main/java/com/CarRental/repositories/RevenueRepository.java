package com.CarRental.repositories;

import com.CarRental.domain.Revenue;

import java.util.Set;


public interface RevenueRepository extends CrudRepository<Revenue, String> {

    Set<Revenue> getAll();
}
