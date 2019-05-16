package com.CarRental.service.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.factories.VehiclePurchasePriceFactory;
import com.CarRental.repositories.impl.VehiclePurchasePriceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehiclePurchasePriceServiceImplTest {

    private VehiclePurchasePriceRepositoryImpl repository;
    private VehiclePurchasePrice vehiclePurchasePrice;

    private VehiclePurchasePrice getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = VehiclePurchasePriceRepositoryImpl.getRepository();
        this.vehiclePurchasePrice = VehiclePurchasePriceFactory.buildVehiclePurchasePrice("452", "2016", "160000");
    }

    @Test
    public void a_create() {
        VehiclePurchasePrice created = this.repository.create(this.vehiclePurchasePrice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.vehiclePurchasePrice);
    }

    @Test
    public void c_update() {
        String newVehiclePurchasePriceName = "Application Development Theory 3";
        VehiclePurchasePrice updated = new VehiclePurchasePrice.Builder().copy(getSaved()).vehiclePurchasePriceId(newVehiclePurchasePriceName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newVehiclePurchasePriceName, updated.getVehiclePurchasePriceId());
    }

    @Test
    public void e_delete() {
        VehiclePurchasePrice saved = getSaved();
        this.repository.delete(saved.getVehiclePurchasePriceId());
        d_getAll();
    }

    @Test
    public void b_read() {
        VehiclePurchasePrice saved = getSaved();
        VehiclePurchasePrice read = this.repository.read(saved.getVehiclePurchasePriceId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<VehiclePurchasePrice> vehiclePurchasePrices = this.repository.getAll();
        System.out.println("In getall, all = " + vehiclePurchasePrices);
    }
}
