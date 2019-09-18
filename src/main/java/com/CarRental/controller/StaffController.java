package com.CarRental.controller;

import com.CarRental.domain.Staff;
import com.CarRental.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService service;

    @GetMapping("/create")
    @ResponseBody
    public Staff create(Staff staff) {
        return service.create(staff);
    }

    @GetMapping("/update")
    @ResponseBody
    public Staff update(Staff staff) {
        return service.update(staff);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Staff read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Staff> getAll() {
        return service.getAll();
    }

}
