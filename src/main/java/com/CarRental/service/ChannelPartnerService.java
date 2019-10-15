package com.CarRental.service;

import com.CarRental.domain.ChannelPartner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChannelPartnerService extends IService<ChannelPartner, String>{
    List<ChannelPartner> getAll();
}
