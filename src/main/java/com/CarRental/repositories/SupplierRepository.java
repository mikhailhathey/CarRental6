package com.CarRental.repositories;

import com.CarRental.domain.Supplier;

import java.util.Set;


public interface SupplierRepository extends CrudRepository<Supplier, String> {

    Set<Supplier> getAll();
}
