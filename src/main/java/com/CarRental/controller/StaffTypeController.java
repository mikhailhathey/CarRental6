package com.CarRental.controller;

import com.CarRental.domain.StaffType;
import com.CarRental.service.StaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/staffType")
public class StaffTypeController {
    @Autowired
    @Qualifier("StaffTypeServiceImpl")
    private StaffTypeService service;

    @PostMapping("/create")
    @ResponseBody
    public StaffType create(StaffType staffType) {
        return service.create(staffType);
    }

    @PostMapping("/update")
    @ResponseBody
    public StaffType update(StaffType staffType) {
        return service.update(staffType);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public StaffType read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<StaffType> getAll() {
        return service.getAll();
    }

}
