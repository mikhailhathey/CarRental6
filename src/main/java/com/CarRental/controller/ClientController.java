package com.CarRental.controller;

import com.CarRental.domain.Client;
import com.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    //@Qualifier("ClientServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/update")
    @ResponseBody
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Client read(@PathVariable String id) {
        return clientService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Client> getAll() {
        return clientService.getAll();
    }

}
