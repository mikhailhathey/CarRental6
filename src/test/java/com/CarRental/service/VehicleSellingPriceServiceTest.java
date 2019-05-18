package com.CarRental.service;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.factories.VehicleSellingPriceFactory;
import com.CarRental.repositories.impl.VehicleSellingPriceRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class VehicleSellingPriceServiceTest {

    private VehicleSellingPriceRepositoryImpl repository;
    private VehicleSellingPrice vehicleSellingPrice;


    @Before
    public void setUp() throws Exception {
        this.repository = VehicleSellingPriceRepositoryImpl.getRepository();
        this.vehicleSellingPrice = VehicleSellingPriceFactory.buildVehicleSellingPrice("452", "2016", "180000");
    }

    @Test
    public void getAll() {
        Set<VehicleSellingPrice> vehicleSellingPrice = this.repository.getAll();
        System.out.println("In getall, all = " + vehicleSellingPrice);
    }

}
