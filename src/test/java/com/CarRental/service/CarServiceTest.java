package com.CarRental.service;

import com.CarRental.domain.Car;
import com.CarRental.factories.CarFactory;
import com.CarRental.repositories.impl.CarRepositoryImpl;
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
public class CarServiceTest {

    private CarRepositoryImpl repository;
    private Car car;


    @Before
    public void setUp() throws Exception {
        this.repository = CarRepositoryImpl.getRepository();
        this.car = CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016");
    }

    @Test
    public void getAll() {
        Set<Car> car = this.repository.getAll();
        System.out.println("In getall, all = " + car);
    }

}
