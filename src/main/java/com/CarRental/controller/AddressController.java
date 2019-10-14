package com.CarRental.controller;

import com.CarRental.domain.Address;
import com.CarRental.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    //@Qualifier("AddressServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return addressService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        addressService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Address> getAll() {
        return addressService.getAll();
    }

}
