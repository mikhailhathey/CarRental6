package com.CarRental.controller;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.service.VehiclePurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/vehiclePurchasePrice")
public class VehiclePurchasePriceController {
    @Autowired
    @Qualifier("VehiclePurchasePriceServiceImpl")
    private VehiclePurchasePriceService service;

    @PostMapping("/create")
    @ResponseBody
    public VehiclePurchasePrice create(VehiclePurchasePrice vehiclePurchasePrice) {
        return service.create(vehiclePurchasePrice);
    }

    @PostMapping("/update")
    @ResponseBody
    public VehiclePurchasePrice update(VehiclePurchasePrice vehiclePurchasePrice) {
        return service.update(vehiclePurchasePrice);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public VehiclePurchasePrice read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<VehiclePurchasePrice> getAll() {
        return service.getAll();
    }

}
