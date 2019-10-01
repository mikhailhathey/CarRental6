package com.CarRental.service.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.repositories.ChannelPartnerRepository;
import com.CarRental.service.ChannelPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ChannelPartnerServiceImpl")
public class ChannelPartnerServiceImpl implements ChannelPartnerService {

    @Autowired
    private ChannelPartnerRepository channelPartnerRepository;

    @Override
    public List<ChannelPartner> getAll() {
        return this.channelPartnerRepository.findAll();
    }

    @Override
    public ChannelPartner create(ChannelPartner channelPartner) {
        return this.channelPartnerRepository.save(channelPartner);
    }

    @Override
    public ChannelPartner read(String channelPartnerId) {
        Optional<ChannelPartner> byId = this.channelPartnerRepository.findById(channelPartnerId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public ChannelPartner update(ChannelPartner channelPartner) {
        return this.channelPartnerRepository.save(channelPartner);
    }

    @Override
    public void delete(String channelPartnerId) {
        this.channelPartnerRepository.deleteById(channelPartnerId);
    }
}
