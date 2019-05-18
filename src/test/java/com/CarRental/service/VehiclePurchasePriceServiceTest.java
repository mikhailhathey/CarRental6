package com.CarRental.service;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.factories.VehiclePurchasePriceFactory;
import com.CarRental.repositories.impl.VehiclePurchasePriceRepositoryImpl;
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
public class VehiclePurchasePriceServiceTest {

    private VehiclePurchasePriceRepositoryImpl repository;
    private VehiclePurchasePrice vehiclePurchasePrice;


    @Before
    public void setUp() throws Exception {
        this.repository = VehiclePurchasePriceRepositoryImpl.getRepository();
        this.vehiclePurchasePrice = VehiclePurchasePriceFactory.buildVehiclePurchasePrice("452", "2016", "160000");
    }

    @Test
    public void getAll() {
        Set<VehiclePurchasePrice> vehiclePurchasePrice = this.repository.getAll();
        System.out.println("In getall, all = " + vehiclePurchasePrice);
    }

}
