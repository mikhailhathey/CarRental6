package com.CarRental.service.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.repositories.SupplierRepository;
import com.CarRental.repositories.impl.SupplierRepositoryImpl;
import com.CarRental.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static SupplierServiceImpl service = null;
    private SupplierRepository repository;

    private SupplierServiceImpl() {
        this.repository = SupplierRepositoryImpl.getRepository();
    }

    public static SupplierServiceImpl getService(){
        if (service == null) service = new SupplierServiceImpl();
        return service;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.create(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.repository.update(supplier);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Supplier read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Supplier> getAll() {
        return this.repository.getAll();
    }
}
