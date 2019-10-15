package com.CarRental.factories;

import com.CarRental.domain.Supplier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupplierFactoryTest {

    public void testBuildSupplier(){

    }

    private String SupplierTest;

    @Before
    public void setUp() throws Exception {
        this.SupplierTest = "SupplierTest";
    }

    @Test
    public void buildSupplier() {
        Supplier supplier = SupplierFactory.buildSupplier(453, "Makro", "Johan", "johan@makro.com");
        System.out.println(supplier);
        Assert.assertNotNull(supplier.getSupplierId());
    }
}