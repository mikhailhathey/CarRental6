package com.CarRental.controller;

import com.CarRental.domain.Perishables;
import com.CarRental.service.PerishablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/perishables")
public class PerishablesController {
    @Autowired
    @Qualifier("PerishablesServiceImpl")
    private PerishablesService service;

    @PostMapping("/create")
    @ResponseBody
    public Perishables create(Perishables perishables) {
        return service.create(perishables);
    }

    @PostMapping("/update")
    @ResponseBody
    public Perishables update(Perishables perishables) {
        return service.update(perishables);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Perishables read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Perishables> getAll() {
        return service.getAll();
    }

}
