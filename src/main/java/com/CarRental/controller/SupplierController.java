package com.CarRental.controller;

import com.CarRental.domain.Supplier;
import com.CarRental.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    @Qualifier("SupplierServiceImpl")
    private SupplierService service;

    @PostMapping("/create")
    @ResponseBody
    public Supplier create(Supplier supplier) {
        return service.create(supplier);
    }

    @PostMapping("/update")
    @ResponseBody
    public Supplier update(Supplier supplier) {
        return service.update(supplier);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Supplier read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Supplier> getAll() {
        return service.getAll();
    }

}
