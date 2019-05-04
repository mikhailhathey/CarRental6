package com.CarRental.repositories.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.factories.VehicleSellingPriceFactory;
import com.CarRental.repositories.VehicleSellingPriceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleSellingPriceRepositoryImplTest {

    private VehicleSellingPriceRepository repository;
    private VehicleSellingPrice vehicleSellingPrice;

    private VehicleSellingPrice getSavedVehicleSellingPrice() {
        Set<VehicleSellingPrice> savedVehicleSellingPrices = this.repository.getAll();
        return savedVehicleSellingPrices.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.vehicleSellingPrice);
    }

    @Test
    public void b_read() {
       VehicleSellingPrice savedVehicleSellingPrice = getSavedVehicleSellingPrice();
        System.out.println("In read, vehicleSellingPriceId = "+ savedVehicleSellingPrice.getVehicleSellingPriceId());
        VehicleSellingPrice read = this.repository.read(savedVehicleSellingPrice.getVehicleSellingPriceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedVehicleSellingPrice, read);
    }

    @Test
    public void e_delete() {
        VehicleSellingPrice savedVehicleSellingPrice = getSavedVehicleSellingPrice();
        this.repository.delete(savedVehicleSellingPrice.getVehicleSellingPriceId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test VehicleSellingPrice Name";
        VehicleSellingPrice vehicleSellingPrice = new VehicleSellingPrice.Builder().copy(getSavedVehicleSellingPrice()).vehiclePrice(newname).build();
        System.out.println("In update, about_to_updated = " + vehicleSellingPrice);
        VehicleSellingPrice updated = this.repository.update(vehicleSellingPrice);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getVehiclePrice());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<VehicleSellingPrice> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
