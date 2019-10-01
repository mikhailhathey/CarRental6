package com.CarRental.service.impl;

import com.CarRental.domain.Car;
import com.CarRental.factories.CarFactory;
import com.CarRental.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarServiceImplTest {
  @Autowired
  @Qualifier("CarServiceImpl")
  private CarService carService;
  private Car car;
  private Set<Car> cars = new HashSet<>();

  @Before
  public void setUp() {
      car = carService.create(CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016"));
      cars.add(car);
  }

  @Test
  public void create() {
      Car createCar = carService.create(CarFactory.buildCar(
              "123456", "13443975", "Ford", "Fiesta", "2016"));
      cars.add(createCar);
      Assert.assertEquals(createCar, carService.read(createCar.getCarId()));
  }

  @Test
  public void read() {
      Car readTestCar = carService.create(CarFactory.buildCar(
              "123456", "13443975", "Ford", "Fiesta", "2016"));
      Assert.assertEquals(readTestCar, carService.read(readTestCar.getCarId()));
  }

  @Test
  public void update() {
      String newCarName = "Test";
      Car updateCar = carService.update(new Car.Builder().copy(car).modelName(newCarName).build());
      cars.add(updateCar);
      Assert.assertEquals(updateCar, carService.read(updateCar.getCarId()));
  }

  @Test
  public void delete() {
      cars.addAll(carService.getAll());
      Car deleteCar = carService.create(CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016"));
      cars.add(deleteCar);
      cars.remove(deleteCar);
      carService.delete(deleteCar.getCarId());
      Assert.assertEquals(cars.size(), carService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Car> carSet = carService.getAll();
      Assert.assertEquals(carSet.size(), carService.getAll().size());
  }
}
//"123456", "13443975", "Ford", "Fiesta", "2016"
