package com.CarRental.controller;

import com.CarRental.domain.RentalTerm;
import com.CarRental.service.RentalTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rentalTerm")
public class RentalTermController {
    @Autowired
    @Qualifier("RentalTermServiceImpl")
    private RentalTermService service;

    @PostMapping("/create")
    @ResponseBody
    public RentalTerm create(RentalTerm rentalTerm) {
        return service.create(rentalTerm);
    }

    @PostMapping("/update")
    @ResponseBody
    public RentalTerm update(RentalTerm rentalTerm) {
        return service.update(rentalTerm);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RentalTerm read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<RentalTerm> getAll() {
        return service.getAll();
    }

}
