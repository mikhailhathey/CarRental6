package com.CarRental.controller;

import com.CarRental.domain.Claims;
import com.CarRental.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/claims")
public class ClaimsController {
    @Autowired
    @Qualifier("ClaimsServiceImpl")
    private ClaimsService service;

    @GetMapping("/create")
    @ResponseBody
    public Claims create(Claims claims) {
        return service.create(claims);
    }

    @GetMapping("/update")
    @ResponseBody
    public Claims update(Claims claims) {
        return service.update(claims);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Claims read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Claims> getAll() {
        return service.getAll();
    }

}
