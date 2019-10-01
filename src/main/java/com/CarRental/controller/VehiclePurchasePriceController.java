package com.CarRental.controller;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.service.VehiclePurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiclePurchasePrice")
public class VehiclePurchasePriceController {
    @Autowired
    private VehiclePurchasePriceService vehiclePurchasePriceService;
    //@Qualifier("VehiclePurchasePriceServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public VehiclePurchasePrice create(@RequestBody VehiclePurchasePrice vehiclePurchasePrice) {
        return vehiclePurchasePriceService.create(vehiclePurchasePrice);
    }

    @PutMapping("/update")
    @ResponseBody
    public VehiclePurchasePrice update(@RequestBody VehiclePurchasePrice vehiclePurchasePrice) {
        return vehiclePurchasePriceService.update(vehiclePurchasePrice);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public VehiclePurchasePrice read(@PathVariable String id) {
        return vehiclePurchasePriceService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        vehiclePurchasePriceService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<VehiclePurchasePrice> getAll() {
        return vehiclePurchasePriceService.getAll();
    }

}
