package com.CarRental.repositories.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.repositories.SupplierRepository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> supplier;

    private SupplierRepositoryImpl(){
        this.supplier = new HashSet<>();
    }

    private Supplier findSupplier(String supplierId) {
        return this.supplier.stream()
                .filter(supplier -> supplier.getSupplierId().trim().equals(supplierId))
                .findAny()
                .orElse(null);
    }

    public static SupplierRepositoryImpl getRepository(){
        if (repository == null) repository = new SupplierRepositoryImpl();
        return repository;
    }


    public Supplier create(Supplier supplier){
        this.supplier.add(supplier);
        return supplier;
    }

    public Supplier read(final String supplierId){
        Supplier supplier = findSupplier(supplierId);
        return supplier;
    }

    public void delete(String supplierId) {
        Supplier supplier = findSupplier(supplierId);
        if (supplier != null) this.supplier.remove(supplier);
    }

    public Supplier update(Supplier supplier){
        Supplier toDelete = findSupplier(supplier.getSupplierId());
        if(toDelete != null) {
            this.supplier.remove(toDelete);
            return create(supplier);
        }
        return null;
    }


    public Set<Supplier> getAll(){
        return this.supplier;
    }
}
