package com.CarRental.repositories;

import com.CarRental.domain.RentalTerm;

import java.util.Set;


public interface RentalTermRepository extends CrudRepository<RentalTerm, String> {

    Set<RentalTerm> getAll();
}
