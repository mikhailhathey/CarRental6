package com.CarRental.controller;

import com.CarRental.domain.Expenses;
import com.CarRental.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    @Autowired
    @Qualifier("ExpensesServiceImpl")
    private ExpensesService service;

    @GetMapping("/create")
    @ResponseBody
    public Expenses create(Expenses expenses) {
        return service.create(expenses);
    }

    @GetMapping("/update")
    @ResponseBody
    public Expenses update(Expenses expenses) {
        return service.update(expenses);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Expenses read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Expenses> getAll() {
        return service.getAll();
    }

}
