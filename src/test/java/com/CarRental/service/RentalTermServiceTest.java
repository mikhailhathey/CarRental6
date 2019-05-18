package com.CarRental.service;

import com.CarRental.domain.RentalTerm;
import com.CarRental.factories.RentalTermFactory;
import com.CarRental.repositories.impl.RentalTermRepositoryImpl;
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
public class RentalTermServiceTest {

    private RentalTermRepositoryImpl repository;
    private RentalTerm rentalTerm;


    @Before
    public void setUp() throws Exception {
        this.repository = RentalTermRepositoryImpl.getRepository();
        this.rentalTerm = RentalTermFactory.buildRentalTerm("324", "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD");
    }

    @Test
    public void getAll() {
        Set<RentalTerm> rentalTerm = this.repository.getAll();
        System.out.println("In getall, all = " + rentalTerm);
    }

}
