package com.CarRental.controller;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.service.ChannelPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/channelPartner")
public class ChannelPartnerController {
    @Autowired
    private ChannelPartnerService channelPartnerService;
    //@Qualifier("ChannelPartnerServiceImpl")

    @PostMapping("/create")
    @ResponseBody
    public ChannelPartner create(@RequestBody ChannelPartner channelPartner) {
        return channelPartnerService.create(channelPartner);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ChannelPartner update(@RequestBody ChannelPartner channelPartner) {
        return channelPartnerService.update(channelPartner);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ChannelPartner read(@PathVariable Integer id) {
        return channelPartnerService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        channelPartnerService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<ChannelPartner> getAll() {
        return channelPartnerService.getAll();
    }

}
