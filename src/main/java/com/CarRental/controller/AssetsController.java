package com.CarRental.controller;

import com.CarRental.domain.Assets;
import com.CarRental.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    @Qualifier("AssetsServiceImpl")
    private AssetsService service;

    @PostMapping("/create")
    @ResponseBody
    public Assets create(Assets assets) {
        return service.create(assets);
    }

    @PostMapping("/update")
    @ResponseBody
    public Assets update(Assets assets) {
        return service.update(assets);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Assets read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Assets> getAll() {
        return service.getAll();
    }

}
