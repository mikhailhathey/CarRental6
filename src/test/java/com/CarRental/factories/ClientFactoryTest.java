package com.CarRental.factories;

import com.CarRental.domain.Client;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientFactoryTest {

    public void testBuildClient(){

    }

    private String ClientTest;

    @Before
    public void setUp() throws Exception {
        this.ClientTest = "ClientTest";
    }

    @Test
    public void buildClient() {
        Client client = ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Street Road");
        System.out.println(client);
        Assert.assertNotNull(client.getClientId());
    }
}


/*

import com.CarRental.domain.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarFactoryTest {

    public void testBuildCar(){

    }

    private String CarTest

    @Before
    public void setUp() throws Exception {
        this.CarTest = "CarTest";
    }

    @Test
    public void buildCar() {
        Car car = CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016")
        System.out.println(car);
        Assert.assertNotNull(car.getCarId());
    }
}*/
