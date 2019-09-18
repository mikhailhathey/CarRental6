package com.CarRental.controller;

import com.CarRental.domain.Contact;
import com.CarRental.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService service;

    @GetMapping("/create")
    @ResponseBody
    public Contact create(Contact contact) {
        return service.create(contact);
    }

    @GetMapping("/update")
    @ResponseBody
    public Contact update(Contact contact) {
        return service.update(contact);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Contact> getAll() {
        return service.getAll();
    }

}
