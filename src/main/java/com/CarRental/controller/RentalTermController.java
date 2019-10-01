package com.CarRental.controller;

import com.CarRental.domain.RentalTerm;
import com.CarRental.service.RentalTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalTerm")
public class RentalTermController {
    @Autowired
    private RentalTermService rentalTermService;
    //@Qualifier("RentalTermServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public RentalTerm create(@RequestBody RentalTerm rentalTerm) {
        return rentalTermService.create(rentalTerm);
    }

    @PutMapping("/update")
    @ResponseBody
    public RentalTerm update(@RequestBody RentalTerm rentalTerm) {
        return rentalTermService.update(rentalTerm);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RentalTerm read(@PathVariable String id) {
        return rentalTermService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        rentalTermService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<RentalTerm> getAll() {
        return rentalTermService.getAll();
    }

}
