package com.CarRental.controller;

import com.CarRental.domain.Claims;
import com.CarRental.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/claims")
public class ClaimsController {
    @Autowired
    private ClaimsService claimsService;
    //@Qualifier("ClaimsServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Claims create(@RequestBody Claims claims) {
        return claimsService.create(claims);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Claims update(@RequestBody Claims claims) {
        return claimsService.update(claims);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Claims read(@PathVariable Integer id) {
        return claimsService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        claimsService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Claims> getAll() {
        return claimsService.getAll();
    }

}
