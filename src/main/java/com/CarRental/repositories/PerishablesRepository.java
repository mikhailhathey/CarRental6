package com.CarRental.repositories;

import com.CarRental.domain.Perishables;

import java.util.Set;


public interface PerishablesRepository extends CrudRepository<Perishables, String> {

    Set<Perishables> getAll();
}
