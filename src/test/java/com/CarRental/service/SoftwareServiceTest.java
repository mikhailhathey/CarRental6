package com.CarRental.service;

import com.CarRental.domain.Software;
import com.CarRental.factories.SoftwareFactory;
import com.CarRental.repositories.impl.SoftwareRepositoryImpl;
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
public class SoftwareServiceTest {

    private SoftwareRepositoryImpl repository;
    private Software software;


    @Before
    public void setUp() throws Exception {
        this.repository = SoftwareRepositoryImpl.getRepository();
        this.software = SoftwareFactory.buildSoftware("769", "Pascal", "2.6", "3000");
    }

    @Test
    public void getAll() {
        Set<Software> software = this.repository.getAll();
        System.out.println("In getall, all = " + software);
    }

}
