package com.CarRental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndexController{
    //@GetMapping("/")
    @RequestMapping(value = "/index")
    public ResponseEntity getHome(){
        return new ResponseEntity("Welcome to the Car Rental Application", HttpStatus.OK);
    }
}
