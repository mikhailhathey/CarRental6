package com.CarRental.service;

import com.CarRental.domain.ChannelPartner;

import java.util.List;

public interface ChannelPartnerService extends IService<ChannelPartner, String>{
    List<ChannelPartner> getAll();
}
