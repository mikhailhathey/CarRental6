package com.CarRental.service.impl;

import com.CarRental.domain.Car;
import com.CarRental.factories.CarFactory;
import com.CarRental.repositories.impl.CarRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarServiceImplTest {

    private CarRepositoryImpl repository;
    private Car car;

    private Car getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CarRepositoryImpl.getRepository();
        this.car = CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016");
    }

    @Test
    public void a_create() {
        Car created = this.repository.create(this.car);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.car);
    }

    @Test
    public void c_update() {
        String newCarName = "Application Development Theory 3";
        Car updated = new Car.Builder().copy(getSaved()).carId(newCarName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCarName, updated.getCarId());
    }

    @Test
    public void e_delete() {
        Car saved = getSaved();
        this.repository.delete(saved.getCarId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Car saved = getSaved();
        Car read = this.repository.read(saved.getCarId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Car> cars = this.repository.getAll();
        System.out.println("In getall, all = " + cars);
    }
}
