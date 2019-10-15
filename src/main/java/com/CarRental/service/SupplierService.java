package com.CarRental.service;

import com.CarRental.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService extends IService<Supplier, String>{
    List<Supplier> getAll();
}
