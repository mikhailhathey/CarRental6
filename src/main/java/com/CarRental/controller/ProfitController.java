package com.CarRental.controller;

import com.CarRental.domain.Profit;
import com.CarRental.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profit")
public class ProfitController {
    @Autowired
    private ProfitService profitService;
    //@Qualifier("ProfitServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Profit create(@RequestBody Profit profit) {
        return profitService.create(profit);
    }

    @PutMapping("/update")
    @ResponseBody
    public Profit update(@RequestBody Profit profit) {
        return profitService.update(profit);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Profit read(@PathVariable String id) {
        return profitService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        profitService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Profit> getAll() {
        return profitService.getAll();
    }

}
