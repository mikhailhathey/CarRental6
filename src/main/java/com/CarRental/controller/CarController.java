package com.CarRental.controller;

import com.CarRental.domain.Car;
import com.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    //@Qualifier("CarServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("/update")
    @ResponseBody
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Car read(@PathVariable String id) {
        return carService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        carService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Car> getAll() {
        return carService.getAll();
    }

}
