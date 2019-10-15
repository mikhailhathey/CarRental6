package com.CarRental.controller;

import com.CarRental.domain.Contact;
import com.CarRental.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    //@Qualifier("ContactServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable Integer id) {
        return contactService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Contact> getAll() {
        return contactService.getAll();
    }

}
