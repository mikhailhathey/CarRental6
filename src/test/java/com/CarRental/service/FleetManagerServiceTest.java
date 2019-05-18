package com.CarRental.service;

import com.CarRental.domain.FleetManager;
import com.CarRental.factories.FleetManagerFactory;
import com.CarRental.repositories.impl.FleetManagerRepositoryImpl;
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
public class FleetManagerServiceTest {

    private FleetManagerRepositoryImpl repository;
    private FleetManager fleetManager;


    @Before
    public void setUp() throws Exception {
        this.repository = FleetManagerRepositoryImpl.getRepository();
        this.fleetManager = FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth");
    }

    @Test
    public void getAll() {
        Set<FleetManager> fleetManager = this.repository.getAll();
        System.out.println("In getall, all = " + fleetManager);
    }

}
