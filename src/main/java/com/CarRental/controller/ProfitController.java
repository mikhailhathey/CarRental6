package com.CarRental.controller;

import com.CarRental.domain.Profit;
import com.CarRental.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/profit")
public class ProfitController {
    @Autowired
    @Qualifier("ProfitServiceImpl")
    private ProfitService service;

    @PostMapping("/create")
    @ResponseBody
    public Profit create(Profit profit) {
        return service.create(profit);
    }

    @PostMapping("/update")
    @ResponseBody
    public Profit update(Profit profit) {
        return service.update(profit);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Profit read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Profit> getAll() {
        return service.getAll();
    }

}
