package com.CarRental.controller;

import com.CarRental.domain.Staff;
import com.CarRental.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    //@Qualifier("StaffServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Staff create(@RequestBody Staff staff) {
        return staffService.create(staff);
    }

    @PutMapping("/update")
    @ResponseBody
    public Staff update(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Staff read(@PathVariable String id) {
        return staffService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        staffService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Staff> getAll() {
        return staffService.getAll();
    }

}
