package com.CarRental.factories;

import com.CarRental.domain.VehiclePurchasePrice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehiclePurchasePriceFactoryTest {

    public void testBuildVehiclePurchasePrice(){

    }

    private String VehiclePurchasePriceTest;

    @Before
    public void setUp() throws Exception {
        this.VehiclePurchasePriceTest = "VehiclePurchasePriceTest";
    }

    @Test
    public void buildVehiclePurchasePrice() {
        VehiclePurchasePrice vehiclePurchasePrice = VehiclePurchasePriceFactory.buildVehiclePurchasePrice("452", "2016", "160000");
        System.out.println(vehiclePurchasePrice);
        Assert.assertNotNull(vehiclePurchasePrice.getVehiclePurchasePriceId());
    }
}