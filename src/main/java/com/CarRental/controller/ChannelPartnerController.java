package com.CarRental.controller;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.service.ChannelPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/channelPartner")
public class ChannelPartnerController {
    @Autowired
    @Qualifier("ChannelPartnerServiceImpl")
    private ChannelPartnerService service;

    @GetMapping("/create")
    @ResponseBody
    public ChannelPartner create(ChannelPartner channelPartner) {
        return service.create(channelPartner);
    }

    @GetMapping("/update")
    @ResponseBody
    public ChannelPartner update(ChannelPartner channelPartner) {
        return service.update(channelPartner);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ChannelPartner read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<ChannelPartner> getAll() {
        return service.getAll();
    }

}
