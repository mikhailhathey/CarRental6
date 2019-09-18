package com.CarRental.controller;

import com.CarRental.domain.Car;
import com.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    @Qualifier("CarServiceImpl")
    private CarService service;

    @GetMapping("/create")
    @ResponseBody
    public Car create(Car car) {
        return service.create(car);
    }

    @GetMapping("/update")
    @ResponseBody
    public Car update(Car car) {
        return service.update(car);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Car read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Car> getAll() {
        return service.getAll();
    }

}
