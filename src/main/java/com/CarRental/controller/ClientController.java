package com.CarRental.controller;

import com.CarRental.domain.Client;
import com.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    @Qualifier("ClientServiceImpl")
    private ClientService service;

    @PostMapping("/create")
    @ResponseBody
    public Client create(Client client) {
        return service.create(client);
    }

    @PostMapping("/update")
    @ResponseBody
    public Client update(Client client) {
        return service.update(client);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Client read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Client> getAll() {
        return service.getAll();
    }

}
