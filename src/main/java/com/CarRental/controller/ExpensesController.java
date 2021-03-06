package com.CarRental.controller;

import com.CarRental.domain.Expenses;
import com.CarRental.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    @Autowired
    private ExpensesService expensesService;
    //@Qualifier("ExpensesServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Expenses create(@RequestBody Expenses expenses) {
        return expensesService.create(expenses);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Expenses update(@RequestBody Expenses expenses) {
        return expensesService.update(expenses);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Expenses read(@PathVariable Integer id) {
        return expensesService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        expensesService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Expenses> getAll() {
        return expensesService.getAll();
    }

}
