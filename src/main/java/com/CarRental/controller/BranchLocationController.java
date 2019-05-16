package com.CarRental.controller;

import com.CarRental.domain.BranchLocation;
import com.CarRental.service.BranchLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/branchLocation")
public class BranchLocationController {
    @Autowired
    @Qualifier("BranchLocationServiceImpl")
    private BranchLocationService service;

    @PostMapping("/create")
    @ResponseBody
    public BranchLocation create(BranchLocation branchLocation) {
        return service.create(branchLocation);
    }

    @PostMapping("/update")
    @ResponseBody
    public BranchLocation update(BranchLocation branchLocation) {
        return service.update(branchLocation);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public BranchLocation read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<BranchLocation> getAll() {
        return service.getAll();
    }

}
