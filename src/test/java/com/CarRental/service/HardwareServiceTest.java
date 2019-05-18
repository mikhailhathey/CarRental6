package com.CarRental.service;

import com.CarRental.domain.Hardware;
import com.CarRental.factories.HardwareFactory;
import com.CarRental.repositories.impl.HardwareRepositoryImpl;
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
public class HardwareServiceTest {

    private HardwareRepositoryImpl repository;
    private Hardware hardware;


    @Before
    public void setUp() throws Exception {
        this.repository = HardwareRepositoryImpl.getRepository();
        this.hardware = HardwareFactory.buildHardware("456", "Laptop", "4500");
    }

    @Test
    public void getAll() {
        Set<Hardware> hardware = this.repository.getAll();
        System.out.println("In getall, all = " + hardware);
    }

}
