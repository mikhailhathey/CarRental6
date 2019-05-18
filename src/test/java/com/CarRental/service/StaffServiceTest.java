package com.CarRental.service;

import com.CarRental.domain.Staff;
import com.CarRental.factories.StaffFactory;
import com.CarRental.repositories.impl.StaffRepositoryImpl;
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
public class StaffServiceTest {

    private StaffRepositoryImpl repository;
    private Staff staff;


    @Before
    public void setUp() throws Exception {
        this.repository = StaffRepositoryImpl.getRepository();
        this.staff = StaffFactory.buildStaff("345", "August", "April", "200000", "Claremont");
    }

    @Test
    public void getAll() {
        Set<Staff> staff = this.repository.getAll();
        System.out.println("In getall, all = " + staff);
    }

}
