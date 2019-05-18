package com.CarRental.service;

import com.CarRental.domain.Perishables;
import com.CarRental.factories.PerishablesFactory;
import com.CarRental.repositories.impl.PerishablesRepositoryImpl;
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
public class PerishablesServiceTest {

    private PerishablesRepositoryImpl repository;
    private Perishables perishables;


    @Before
    public void setUp() throws Exception {
        this.repository = PerishablesRepositoryImpl.getRepository();
        this.perishables = PerishablesFactory.buildPerishables("567", "Bread", "12/05/2019", "5");
    }

    @Test
    public void getAll() {
        Set<Perishables> perishables = this.repository.getAll();
        System.out.println("In getall, all = " + perishables);
    }

}
