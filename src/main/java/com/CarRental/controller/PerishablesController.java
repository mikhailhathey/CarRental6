package com.CarRental.controller;

import com.CarRental.domain.Perishables;
import com.CarRental.service.PerishablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/perishables")
public class PerishablesController {
    @Autowired
    private PerishablesService perishablesService;
    //@Qualifier("PerishablesServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Perishables create(@RequestBody Perishables perishables) {
        return perishablesService.create(perishables);
    }

    @PutMapping("/update")
    @ResponseBody
    public Perishables update(@RequestBody Perishables perishables) {
        return perishablesService.update(perishables);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Perishables read(@PathVariable Integer id) {
        return perishablesService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        perishablesService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Perishables> getAll() {
        return perishablesService.getAll();
    }

}
