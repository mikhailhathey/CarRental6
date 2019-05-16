package com.CarRental.controller;

import com.CarRental.domain.Region;
import com.CarRental.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    @Qualifier("RegionServiceImpl")
    private RegionService service;

    @PostMapping("/create")
    @ResponseBody
    public Region create(Region region) {
        return service.create(region);
    }

    @PostMapping("/update")
    @ResponseBody
    public Region update(Region region) {
        return service.update(region);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Region read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Region> getAll() {
        return service.getAll();
    }

}
