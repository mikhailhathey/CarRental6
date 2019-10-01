package com.CarRental.controller;

import com.CarRental.domain.Hardware;
import com.CarRental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {
    @Autowired
    private HardwareService hardwareService;
    //@Qualifier("HardwareServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Hardware create(@RequestBody Hardware hardware) {
        return hardwareService.create(hardware);
    }

    @PutMapping("/update")
    @ResponseBody
    public Hardware update(@RequestBody Hardware hardware) {
        return hardwareService.update(hardware);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Hardware read(@PathVariable String id) {
        return hardwareService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        hardwareService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Hardware> getAll() {
        return hardwareService.getAll();
    }

}
