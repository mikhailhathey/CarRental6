package com.CarRental.controller;

import com.CarRental.domain.Assets;
import com.CarRental.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;
    //@Qualifier("AssetsServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Assets create(@RequestBody Assets assets) {
        return assetsService.create(assets);
    }

    @PutMapping("/update")
    @ResponseBody
    public Assets update(@RequestBody Assets assets) {
        return assetsService.update(assets);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Assets read(@PathVariable String id) {
        return assetsService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        assetsService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Assets> getAll() {
        return assetsService.getAll();
    }

}
