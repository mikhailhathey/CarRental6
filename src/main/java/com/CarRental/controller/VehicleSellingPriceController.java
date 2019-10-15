package com.CarRental.controller;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.service.VehicleSellingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vehicleSellingPrice")
public class VehicleSellingPriceController {
    @Autowired
    private VehicleSellingPriceService vehicleSellingPriceService;
    //@Qualifier("VehicleSellingPriceServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public VehicleSellingPrice create(@RequestBody VehicleSellingPrice vehicleSellingPrice) {
        return vehicleSellingPriceService.create(vehicleSellingPrice);
    }

    @PutMapping("/update")
    @ResponseBody
    public VehicleSellingPrice update(@RequestBody VehicleSellingPrice vehicleSellingPrice) {
        return vehicleSellingPriceService.update(vehicleSellingPrice);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public VehicleSellingPrice read(@PathVariable Integer id) {
        return vehicleSellingPriceService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        vehicleSellingPriceService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<VehicleSellingPrice> getAll() {
        return vehicleSellingPriceService.getAll();
    }

}
