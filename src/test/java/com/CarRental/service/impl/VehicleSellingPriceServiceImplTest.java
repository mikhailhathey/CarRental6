package com.CarRental.service.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.factories.VehicleSellingPriceFactory;
import com.CarRental.repositories.impl.VehicleSellingPriceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleSellingPriceServiceImplTest {

    private VehicleSellingPriceRepositoryImpl repository;
    private VehicleSellingPrice vehicleSellingPrice;

    private VehicleSellingPrice getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = VehicleSellingPriceRepositoryImpl.getRepository();
        this.vehicleSellingPrice = VehicleSellingPriceFactory.buildVehicleSellingPrice("452", "2016", "180000");
    }

    @Test
    public void a_create() {
        VehicleSellingPrice created = this.repository.create(this.vehicleSellingPrice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.vehicleSellingPrice);
    }

    @Test
    public void c_update() {
        String newVehicleSellingPriceName = "Application Development Theory 3";
        VehicleSellingPrice updated = new VehicleSellingPrice.Builder().copy(getSaved()).vehicleSellingPriceId(newVehicleSellingPriceName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newVehicleSellingPriceName, updated.getVehicleSellingPriceId());
    }

    @Test
    public void e_delete() {
        VehicleSellingPrice saved = getSaved();
        this.repository.delete(saved.getVehicleSellingPriceId());
        d_getAll();
    }

    @Test
    public void b_read() {
        VehicleSellingPrice saved = getSaved();
        VehicleSellingPrice read = this.repository.read(saved.getVehicleSellingPriceId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<VehicleSellingPrice> vehicleSellingPrices = this.repository.getAll();
        System.out.println("In getall, all = " + vehicleSellingPrices);
    }
}
