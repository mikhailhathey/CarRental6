package com.CarRental.controller;

import com.CarRental.domain.FleetManager;
import com.CarRental.service.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/fleetManager")
public class FleetManagerController {
    @Autowired
    @Qualifier("FleetManagerServiceImpl")
    private FleetManagerService service;

    @GetMapping("/create")
    @ResponseBody
    public FleetManager create(FleetManager fleetManager) {
        return service.create(fleetManager);
    }

    @GetMapping("/update")
    @ResponseBody
    public FleetManager update(FleetManager fleetManager) {
        return service.update(fleetManager);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public FleetManager read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<FleetManager> getAll() {
        return service.getAll();
    }

}
