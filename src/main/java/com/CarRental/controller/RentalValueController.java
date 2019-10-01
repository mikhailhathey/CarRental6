package com.CarRental.controller;

import com.CarRental.domain.RentalValue;
import com.CarRental.service.RentalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalValue")
public class RentalValueController {
    @Autowired
    private RentalValueService rentalValueService;
    //@Qualifier("RentalValueServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public RentalValue create(@RequestBody RentalValue rentalValue) {
        return rentalValueService.create(rentalValue);
    }

    @PutMapping("/update")
    @ResponseBody
    public RentalValue update(@RequestBody RentalValue rentalValue) {
        return rentalValueService.update(rentalValue);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RentalValue read(@PathVariable String id) {
        return rentalValueService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        rentalValueService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<RentalValue> getAll() {
        return rentalValueService.getAll();
    }

}
