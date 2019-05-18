package com.CarRental.service;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import com.CarRental.repositories.impl.AddressRepositoryImpl;
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
public class AddressServiceTest {

    private AddressRepositoryImpl repository;
    private Address address;


    @Before
    public void setUp() throws Exception {
        this.repository = AddressRepositoryImpl.getRepository();
        this.address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
    }

    @Test
    public void getAll() {
        Set<Address> address = this.repository.getAll();
        System.out.println("In getall, all = " + address);
    }

}
