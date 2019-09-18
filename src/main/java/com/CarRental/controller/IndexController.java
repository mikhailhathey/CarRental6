package com.CarRental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public ResponseEntity getHome(){
        return new ResponseEntity("Welcome to the Car Rental Application", HttpStatus.OK);
    }
}
