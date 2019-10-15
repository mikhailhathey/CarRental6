package com.CarRental.controller;

import com.CarRental.domain.Infrastructure;
import com.CarRental.service.InfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/infrastructure")
public class InfrastructureController {
    @Autowired
    private InfrastructureService infrastructureService;
    //@Qualifier("InfrastructureServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Infrastructure create(@RequestBody Infrastructure infrastructure) {
        return infrastructureService.create(infrastructure);
    }

    @PutMapping("/update")
    @ResponseBody
    public Infrastructure update(@RequestBody Infrastructure infrastructure) {
        return infrastructureService.update(infrastructure);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Infrastructure read(@PathVariable Integer id) {
        return infrastructureService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        infrastructureService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Infrastructure> getAll() {
        return infrastructureService.getAll();
    }

}
