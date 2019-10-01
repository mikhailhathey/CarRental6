package com.CarRental.controller;

import com.CarRental.domain.FleetManager;
import com.CarRental.service.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    @ResponseBody
    public FleetManager update(@RequestBody FleetManager fleetManager) {
        return fleetManagerService.update(fleetManager);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public FleetManager read(@PathVariable String id) {
        return fleetManagerService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        fleetManagerService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<FleetManager> getAll() {
        return fleetManagerService.getAll();
    }

}
