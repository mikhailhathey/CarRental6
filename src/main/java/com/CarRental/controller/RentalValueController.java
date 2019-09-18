package com.CarRental.controller;

import com.CarRental.domain.RentalValue;
import com.CarRental.service.RentalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rentalValue")
public class RentalValueController {
    @Autowired
    @Qualifier("RentalValueServiceImpl")
    private RentalValueService service;

    @GetMapping("/create")
    @ResponseBody
    public RentalValue create(RentalValue rentalValue) {
        return service.create(rentalValue);
    }

    @GetMapping("/update")
    @ResponseBody
    public RentalValue update(RentalValue rentalValue) {
        return service.update(rentalValue);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RentalValue read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<RentalValue> getAll() {
        return service.getAll();
    }

}
