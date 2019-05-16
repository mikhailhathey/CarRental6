package com.CarRental.service;

import com.CarRental.domain.Supplier;

import java.util.Set;

public interface SupplierService extends CrudService<Supplier, String>{
    Set<Supplier> getAll();
}
