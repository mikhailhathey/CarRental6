package com.CarRental.service;

import com.CarRental.domain.Supplier;
import com.CarRental.factories.SupplierFactory;
import com.CarRental.repositories.impl.SupplierRepositoryImpl;
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
public class SupplierServiceTest {

    private SupplierRepositoryImpl repository;
    private Supplier supplier;


    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();
        this.supplier = SupplierFactory.buildSupplier("453", "Makro", "Johan", "johan@makro.com");
    }

    @Test
    public void getAll() {
        Set<Supplier> supplier = this.repository.getAll();
        System.out.println("In getall, all = " + supplier);
    }

}
