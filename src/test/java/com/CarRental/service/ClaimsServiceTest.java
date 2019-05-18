package com.CarRental.service;

import com.CarRental.domain.Claims;
import com.CarRental.factories.ClaimsFactory;
import com.CarRental.repositories.impl.ClaimsRepositoryImpl;
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
public class ClaimsServiceTest {

    private ClaimsRepositoryImpl repository;
    private Claims claims;


    @Before
    public void setUp() throws Exception {
        this.repository = ClaimsRepositoryImpl.getRepository();
        this.claims = ClaimsFactory.buildClaims("1234", "Discovery", "12000", "Stolen");
    }

    @Test
    public void getAll() {
        Set<Claims> claims = this.repository.getAll();
        System.out.println("In getall, all = " + claims);
    }

}
