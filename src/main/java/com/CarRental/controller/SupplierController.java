package com.CarRental.controller;

import com.CarRental.domain.Supplier;
import com.CarRental.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    //@Qualifier("SupplierServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }

    @PutMapping("/update")
    @ResponseBody
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Supplier read(@PathVariable Integer id) {
        return supplierService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        supplierService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

}
