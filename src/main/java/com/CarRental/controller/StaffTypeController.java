package com.CarRental.controller;

import com.CarRental.domain.StaffType;
import com.CarRental.service.StaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/staffType")
public class StaffTypeController {
    @Autowired
    private StaffTypeService staffTypeService;
    //@Qualifier("StaffTypeServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public StaffType create(@RequestBody StaffType staffType) {
        return staffTypeService.create(staffType);
    }

    @PutMapping("/update")
    @ResponseBody
    public StaffType update(@RequestBody StaffType staffType) {
        return staffTypeService.update(staffType);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public StaffType read(@PathVariable Integer id) {
        return staffTypeService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        staffTypeService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<StaffType> getAll() {
        return staffTypeService.getAll();
    }

}
