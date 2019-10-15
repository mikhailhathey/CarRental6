package com.CarRental.factories;

import com.CarRental.domain.VehicleSellingPrice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleSellingPriceFactoryTest {

    public void testBuildVehicleSellingPrice(){

    }

    private String VehicleSellingPriceTest;

    @Before
    public void setUp() throws Exception {
        this.VehicleSellingPriceTest = "VehicleSellingPriceTest";
    }

    @Test
    public void buildVehicleSellingPrice() {
        VehicleSellingPrice vehicleSellingPrice = VehicleSellingPriceFactory.buildVehicleSellingPrice(452, "2016", "180000");
        System.out.println(vehicleSellingPrice);
        Assert.assertNotNull(vehicleSellingPrice.getVehicleSellingPriceId());
    }
}