package com.CarRental.repositories.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.factories.SupplierFactory;
import com.CarRental.repositories.SupplierRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierRepositoryImplTest {

    private SupplierRepository repository;
    private Supplier supplier;

    private Supplier getSavedSupplier() {
        Set<Supplier> savedSuppliers = this.repository.getAll();
        return savedSuppliers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();
        this.supplier = SupplierFactory.buildSupplier("453", "Makro", "Johan", "johan@makro.com");
    }

    @Test
    public void a_create() {
        Supplier created = this.repository.create(this.supplier);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.supplier);
    }

    @Test
    public void b_read() {
       Supplier savedSupplier = getSavedSupplier();
        System.out.println("In read, supplierId = "+ savedSupplier.getSupplierId());
        Supplier read = this.repository.read(savedSupplier.getSupplierId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSupplier, read);
    }

    @Test
    public void e_delete() {
        Supplier savedSupplier = getSavedSupplier();
        this.repository.delete(savedSupplier.getSupplierId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Supplier Name";
        Supplier supplier = new Supplier.Builder().copy(getSavedSupplier()).supplierName(newname).build();
        System.out.println("In update, about_to_updated = " + supplier);
        Supplier updated = this.repository.update(supplier);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSupplierName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Supplier> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
