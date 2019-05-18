package com.CarRental.service;

import com.CarRental.domain.Infrastructure;
import com.CarRental.factories.InfrastructureFactory;
import com.CarRental.repositories.impl.InfrastructureRepositoryImpl;
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
public class InfrastructureServiceTest {

    private InfrastructureRepositoryImpl repository;
    private Infrastructure infrastructure;


    @Before
    public void setUp() throws Exception {
        this.repository = InfrastructureRepositoryImpl.getRepository();
        this.infrastructure = InfrastructureFactory.buildInfrastructure("789", "Dimension Data", "Network Servers", "50000");
    }

    @Test
    public void getAll() {
        Set<Infrastructure> infrastructure = this.repository.getAll();
        System.out.println("In getall, all = " + infrastructure);
    }

}
