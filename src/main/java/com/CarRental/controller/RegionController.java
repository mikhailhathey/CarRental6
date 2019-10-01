package com.CarRental.controller;

import com.CarRental.domain.Region;
import com.CarRental.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;
    //@Qualifier("RegionServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Region create(@RequestBody Region region) {
        return regionService.create(region);
    }

    @PutMapping("/update")
    @ResponseBody
    public Region update(@RequestBody Region region) {
        return regionService.update(region);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Region read(@PathVariable String id) {
        return regionService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        regionService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Region> getAll() {
        return regionService.getAll();
    }

}
