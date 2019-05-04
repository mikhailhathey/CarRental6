package com.CarRental.repositories.impl;

import com.CarRental.domain.Car;
import com.CarRental.factories.CarFactory;
import com.CarRental.repositories.CarRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarRepositoryImplTest {

    private CarRepository repository;
    private Car car;

    private Car getSavedCar() {
        Set<Car> savedCars = this.repository.getAll();
        return savedCars.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.car);
    }

    @Test
    public void b_read() {
       Car savedCar = getSavedCar();
        System.out.println("In read, carId = "+ savedCar.getCarId());
        Car read = this.repository.read(savedCar.getCarId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCar, read);
    }

    @Test
    public void e_delete() {
        Car savedCar = getSavedCar();
        this.repository.delete(savedCar.getCarId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Car Name";
        Car car = new Car.Builder().copy(getSavedCar()).modelName(newname).build();
        System.out.println("In update, about_to_updated = " + car);
        Car updated = this.repository.update(car);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getModelName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Car> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
