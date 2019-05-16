package com.CarRental.service.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.repositories.ChannelPartnerRepository;
import com.CarRental.repositories.impl.ChannelPartnerRepositoryImpl;
import com.CarRental.service.ChannelPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ChannelPartnerServiceImpl")
public class ChannelPartnerServiceImpl implements ChannelPartnerService {
    @Autowired

    private static ChannelPartnerServiceImpl service = null;
    private ChannelPartnerRepository repository;

    private ChannelPartnerServiceImpl() {
        this.repository = ChannelPartnerRepositoryImpl.getRepository();
    }

    public static ChannelPartnerServiceImpl getService(){
        if (service == null) service = new ChannelPartnerServiceImpl();
        return service;
    }

    @Override
    public ChannelPartner create(ChannelPartner channelPartner) {
        return this.repository.create(channelPartner);
    }

    @Override
    public ChannelPartner update(ChannelPartner channelPartner) {
        return this.repository.update(channelPartner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public ChannelPartner read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<ChannelPartner> getAll() {
        return this.repository.getAll();
    }
}
