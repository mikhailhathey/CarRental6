package com.CarRental.controller;

import com.CarRental.domain.Admin;
import com.CarRental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService service;

    @PostMapping("/create")
    @ResponseBody
    public Admin create(Admin admin) {
        return service.create(admin);
    }

    @PostMapping("/update")
    @ResponseBody
    public Admin update(Admin admin) {
        return service.update(admin);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Admin read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Admin> getAll() {
        return service.getAll();
    }

}
