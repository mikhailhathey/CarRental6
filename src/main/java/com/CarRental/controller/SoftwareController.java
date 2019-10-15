package com.CarRental.controller;

import com.CarRental.domain.Software;
import com.CarRental.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/software")
public class SoftwareController {
    @Autowired
    private SoftwareService softwareService;
    //@Qualifier("SoftwareServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Software create(@RequestBody Software software) {
        return softwareService.create(software);
    }

    @PutMapping("/update")
    @ResponseBody
    public Software update(@RequestBody Software software) {
        return softwareService.update(software);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Software read(@PathVariable Integer id) {
        return softwareService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        softwareService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Software> getAll() {
        return softwareService.getAll();
    }

}
