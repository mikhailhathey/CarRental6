package com.CarRental.controller;

import com.CarRental.domain.Assets;
import com.CarRental.domain.helper.ResponseObj;
import com.CarRental.factories.helper.ResponseObjFactory;
import com.CarRental.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/assets/lookup/assets")
public class AssetsController {
    @Autowired
    @Qualifier("AssetsServiceImpl")
    private AssetsService service;

    @PostMapping(value = "/create/{assets}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String assets) {
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(),"Assets Created");
        Assets savedAssets;
        if (assets == null || assets.trim().isEmpty() || assets.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide Assets!");
        } else {
            savedAssets = service.retrieveByDesc(assets);
            if (savedAssets != null) {
                responseObj.setResponseDescription("Assets already exists!");
            } else {
                //savedAssets = AssetsFactory.buildAssets(assets);
                savedAssets = service.create(savedAssets);
            }
            responseObj.setResponseBody(savedAssets);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Assets> genders = service.getAll();
        responseObj.setResponseBody(genders);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/update/{assets}")
    @ResponseBody
    public Assets update(@PathVariable Assets assets) {
        return service.update(assets);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Assets read(@PathVariable String id) {
        return service.read(id);
    }

}
