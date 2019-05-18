package com.CarRental.service;

import com.CarRental.domain.RentalValue;
import com.CarRental.factories.RentalValueFactory;
import com.CarRental.repositories.impl.RentalValueRepositoryImpl;
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
public class RentalValueServiceTest {

    private RentalValueRepositoryImpl repository;
    private RentalValue rentalValue;


    @Before
    public void setUp() throws Exception {
        this.repository = RentalValueRepositoryImpl.getRepository();
        this.rentalValue = RentalValueFactory.buildRentalValue("902", "Bus", "4000");
    }

    @Test
    public void getAll() {
        Set<RentalValue> rentalValue = this.repository.getAll();
        System.out.println("In getall, all = " + rentalValue);
    }

}
