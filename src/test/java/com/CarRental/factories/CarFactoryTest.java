package com.CarRental.factories;

import com.CarRental.domain.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarFactoryTest {

    public void testBuildCar(){

    }

    private String CarTest;

    @Before
    public void setUp() throws Exception {
        this.CarTest = "CarTest";
    }

    @Test
    public void buildCar() {
        Car car = CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016");
        System.out.println(car);
        Assert.assertNotNull(car.getCarId());
    }
}
