package com.CarRental.controller;

import com.CarRental.domain.BranchLocation;
import com.CarRental.service.BranchLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/branchLocation")
public class BranchLocationController {
    @Autowired
    private BranchLocationService branchLocationService;
    //@Qualifier("BranchLocationServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public BranchLocation create(@RequestBody BranchLocation branchLocation) {
        return branchLocationService.create(branchLocation);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public BranchLocation update(@RequestBody BranchLocation branchLocation) {
        return branchLocationService.update(branchLocation);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public BranchLocation read(@PathVariable Integer id) {
        return branchLocationService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        branchLocationService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<BranchLocation> getAll() {
        return branchLocationService.getAll();
    }

}
