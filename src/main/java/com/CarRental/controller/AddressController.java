package com.CarRental.controller;

import com.CarRental.domain.Address;
import com.CarRental.domain.helper.ResponseObj;
import com.CarRental.factories.helper.ResponseObjFactory;
import com.CarRental.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address/lookup/address")
public class AddressController {
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService service;

    @PostMapping(value = "/create/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String address) {
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(),"Address Created");
        Address savedAddress;
        if (address == null || address.trim().isEmpty() || address.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide Address!");
        } else {
            savedAddress = service.retrieveByDesc(address);
            if (savedAddress != null) {
                responseObj.setResponseDescription("Address already exists!");
            } else {
                //savedAddress = AddressFactory.buildAddress(address);
                savedAddress = service.create(savedAddress);
            }
            responseObj.setResponseBody(savedAddress);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Address> genders = service.getAll();
        responseObj.setResponseBody(genders);
        return ResponseEntity.ok(responseObj);
    }

    /*@PostMapping(value = "/create/{address}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable Address address) {
        ResponseObj responseObj = ResponseObjFactory.buildResponseObj(HttpStatus.OK.toString(),"Address Created");
        if (address == null || address.equals("null")){
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Enter a correct address dummy");
        }
        return ResponseEntity.ok(responseObj);
        //return service.create(address);
    }*/

    @GetMapping("/update/{address}")
    @ResponseBody
    public Address update(@PathVariable Address address) {
        return service.update(address);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return service.read(id);
    }

}
