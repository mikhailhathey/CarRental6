package com.CarRental.repositories.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.factories.VehiclePurchasePriceFactory;
import com.CarRental.repositories.VehiclePurchasePriceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehiclePurchasePriceRepositoryImplTest {

    private VehiclePurchasePriceRepository repository;
    private VehiclePurchasePrice vehiclePurchasePrice;

    private VehiclePurchasePrice getSavedVehiclePurchasePrice() {
        Set<VehiclePurchasePrice> savedVehiclePurchasePrices = this.repository.getAll();
        return savedVehiclePurchasePrices.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.vehiclePurchasePrice);
    }

    @Test
    public void b_read() {
       VehiclePurchasePrice savedVehiclePurchasePrice = getSavedVehiclePurchasePrice();
        System.out.println("In read, vehiclePurchasePriceId = "+ savedVehiclePurchasePrice.getVehiclePurchasePriceId());
        VehiclePurchasePrice read = this.repository.read(savedVehiclePurchasePrice.getVehiclePurchasePriceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedVehiclePurchasePrice, read);
    }

    @Test
    public void e_delete() {
        VehiclePurchasePrice savedVehiclePurchasePrice = getSavedVehiclePurchasePrice();
        this.repository.delete(savedVehiclePurchasePrice.getVehiclePurchasePriceId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test VehiclePurchasePrice Name";
        VehiclePurchasePrice vehiclePurchasePrice = new VehiclePurchasePrice.Builder().copy(getSavedVehiclePurchasePrice()).vehiclePrice(newname).build();
        System.out.println("In update, about_to_updated = " + vehiclePurchasePrice);
        VehiclePurchasePrice updated = this.repository.update(vehiclePurchasePrice);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getVehiclePrice());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<VehiclePurchasePrice> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
