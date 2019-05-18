package com.CarRental.service;

import com.CarRental.domain.Admin;
import com.CarRental.factories.AdminFactory;
import com.CarRental.repositories.impl.AdminRepositoryImpl;
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
public class AdminServiceTest {

    private AdminRepositoryImpl repository;
    private Admin admin;


    @Before
    public void setUp() throws Exception {
        this.repository = AdminRepositoryImpl.getRepository();
        this.admin = AdminFactory.buildAdmin("123", "AdminUser", "Password123");
    }

    @Test
    public void getAll() {
        Set<Admin> admin = this.repository.getAll();
        System.out.println("In getall, all = " + admin);
    }

}
