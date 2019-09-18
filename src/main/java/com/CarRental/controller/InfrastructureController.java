package com.CarRental.controller;

import com.CarRental.domain.Infrastructure;
import com.CarRental.service.InfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/infrastructure")
public class InfrastructureController {
    @Autowired
    @Qualifier("InfrastructureServiceImpl")
    private InfrastructureService service;

    @GetMapping("/create")
    @ResponseBody
    public Infrastructure create(Infrastructure infrastructure) {
        return service.create(infrastructure);
    }

    @GetMapping("/update")
    @ResponseBody
    public Infrastructure update(Infrastructure infrastructure) {
        return service.update(infrastructure);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Infrastructure read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Infrastructure> getAll() {
        return service.getAll();
    }

}
