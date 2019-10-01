package com.CarRental.service;

import com.CarRental.domain.Supplier;

import java.util.List;

public interface SupplierService extends IService<Supplier, String>{
    List<Supplier> getAll();
}
