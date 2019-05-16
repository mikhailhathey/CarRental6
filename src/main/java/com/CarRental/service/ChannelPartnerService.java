package com.CarRental.service;

import com.CarRental.domain.ChannelPartner;

import java.util.Set;

public interface ChannelPartnerService extends CrudService<ChannelPartner, String>{
    Set<ChannelPartner> getAll();
}
