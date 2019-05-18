package com.CarRental.service;

import com.CarRental.domain.StaffType;
import com.CarRental.factories.StaffTypeFactory;
import com.CarRental.repositories.impl.StaffTypeRepositoryImpl;
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
public class StaffTypeServiceTest {

    private StaffTypeRepositoryImpl repository;
    private StaffType staffType;


    @Before
    public void setUp() throws Exception {
        this.repository = StaffTypeRepositoryImpl.getRepository();
        this.staffType = StaffTypeFactory.buildStaffType("765", "Customer Care", "200000");
    }

    @Test
    public void getAll() {
        Set<StaffType> staffType = this.repository.getAll();
        System.out.println("In getall, all = " + staffType);
    }

}
