package com.CarRental.controller;

import com.CarRental.domain.Hardware;
import com.CarRental.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hardware")
public class HardwareController {
    @Autowired
    @Qualifier("HardwareServiceImpl")
    private HardwareService service;

    @GetMapping("/create")
    @ResponseBody
    public Hardware create(Hardware hardware) {
        return service.create(hardware);
    }

    @GetMapping("/update")
    @ResponseBody
    public Hardware update(Hardware hardware) {
        return service.update(hardware);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Hardware read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Hardware> getAll() {
        return service.getAll();
    }

}
