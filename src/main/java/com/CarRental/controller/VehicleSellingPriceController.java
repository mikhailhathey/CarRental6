package com.CarRental.controller;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.service.VehicleSellingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/vehicleSellingPrice")
public class VehicleSellingPriceController {
    @Autowired
    @Qualifier("VehicleSellingPriceServiceImpl")
    private VehicleSellingPriceService service;

    @GetMapping("/create")
    @ResponseBody
    public VehicleSellingPrice create(VehicleSellingPrice vehicleSellingPrice) {
        return service.create(vehicleSellingPrice);
    }

    @GetMapping("/update")
    @ResponseBody
    public VehicleSellingPrice update(VehicleSellingPrice vehicleSellingPrice) {
        return service.update(vehicleSellingPrice);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public VehicleSellingPrice read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<VehicleSellingPrice> getAll() {
        return service.getAll();
    }

}
