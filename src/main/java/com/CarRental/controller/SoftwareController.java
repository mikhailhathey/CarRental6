package com.CarRental.controller;

import com.CarRental.domain.Software;
import com.CarRental.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/software")
public class SoftwareController {
    @Autowired
    @Qualifier("SoftwareServiceImpl")
    private SoftwareService service;

    @GetMapping("/create")
    @ResponseBody
    public Software create(Software software) {
        return service.create(software);
    }

    @GetMapping("/update")
    @ResponseBody
    public Software update(Software software) {
        return service.update(software);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Software read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Software> getAll() {
        return service.getAll();
    }

}
