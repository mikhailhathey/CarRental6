package com.CarRental.service.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.repositories.SupplierRepository;
import com.CarRental.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return this.supplierRepository.findAll();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @Override
    public Supplier read(Integer supplierId) {
        Optional<Supplier> byId = this.supplierRepository.findById(String.valueOf(supplierId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @Override
    public void delete(Integer supplierId) {
        this.supplierRepository.deleteById(String.valueOf(supplierId));
    }
}
