package com.CarRental.service.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.factories.SupplierFactory;
import com.CarRental.repositories.impl.SupplierRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierServiceImplTest {

    private SupplierRepositoryImpl repository;
    private Supplier supplier;

    private Supplier getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.supplier);
    }

    @Test
    public void c_update() {
        String newSupplierName = "Application Development Theory 3";
        Supplier updated = new Supplier.Builder().copy(getSaved()).supplierId(newSupplierName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSupplierName, updated.getSupplierId());
    }

    @Test
    public void e_delete() {
        Supplier saved = getSaved();
        this.repository.delete(saved.getSupplierId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Supplier saved = getSaved();
        Supplier read = this.repository.read(saved.getSupplierId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Supplier> suppliers = this.repository.getAll();
        System.out.println("In getall, all = " + suppliers);
    }
}
