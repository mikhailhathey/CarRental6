package com.CarRental.controller;

import com.CarRental.domain.Revenue;
import com.CarRental.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/revenue")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;
    //@Qualifier("RevenueServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Revenue create(@RequestBody Revenue revenue) {
        return revenueService.create(revenue);
    }

    @PutMapping("/update")
    @ResponseBody
    public Revenue update(@RequestBody Revenue revenue) {
        return revenueService.update(revenue);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Revenue read(@PathVariable Integer id) {
        return revenueService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        revenueService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Revenue> getAll() {
        return revenueService.getAll();
    }

}
