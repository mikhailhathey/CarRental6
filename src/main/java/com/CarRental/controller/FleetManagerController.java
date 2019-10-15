package com.CarRental.controller;

import com.CarRental.domain.FleetManager;
import com.CarRental.service.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fleetManager")
public class FleetManagerController {
    @Autowired
    private FleetManagerService fleetManagerService;
    //@Qualifier("FleetManagerServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public FleetManager create(@RequestBody FleetManager fleetManager) {
        return fleetManagerService.create(fleetManager);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public FleetManager update(@RequestBody FleetManager fleetManager) {
        return fleetManagerService.update(fleetManager);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public FleetManager read(@PathVariable Integer id) {
        return fleetManagerService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        fleetManagerService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<FleetManager> getAll() {
        return fleetManagerService.getAll();
    }

}
