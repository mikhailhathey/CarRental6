package com.CarRental.controller;

import com.CarRental.domain.Revenue;
import com.CarRental.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/revenue")
public class RevenueController {
    @Autowired
    @Qualifier("RevenueServiceImpl")
    private RevenueService service;

    @GetMapping("/create")
    @ResponseBody
    public Revenue create(Revenue revenue) {
        return service.create(revenue);
    }

    @GetMapping("/update")
    @ResponseBody
    public Revenue update(Revenue revenue) {
        return service.update(revenue);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Revenue read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Revenue> getAll() {
        return service.getAll();
    }

}
