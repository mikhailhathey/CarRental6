package com.CarRental.repositories.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.repositories.ChannelPartnerRepository;

import java.util.HashSet;
import java.util.Set;

public class ChannelPartnerRepositoryImpl implements ChannelPartnerRepository {

    private static ChannelPartnerRepositoryImpl repository = null;
    private Set<ChannelPartner> channelPartner;

    private ChannelPartnerRepositoryImpl(){
        this.channelPartner = new HashSet<>();
    }

    private ChannelPartner findChannelPartner(String channelPartnerId) {
        return this.channelPartner.stream()
                .filter(channelPartner -> channelPartner.getChannelPartnerId().trim().equals(channelPartnerId))
                .findAny()
                .orElse(null);
    }

    public static ChannelPartnerRepositoryImpl getRepository(){
        if (repository == null) repository = new ChannelPartnerRepositoryImpl();
        return repository;
    }


    public ChannelPartner create(ChannelPartner channelPartner){
        this.channelPartner.add(channelPartner);
        return channelPartner;
    }

    public ChannelPartner read(final String channelPartnerId){
        ChannelPartner channelPartner = findChannelPartner(channelPartnerId);
        return channelPartner;
    }

    public void delete(String channelPartnerId) {
        ChannelPartner channelPartner = findChannelPartner(channelPartnerId);
        if (channelPartner != null) this.channelPartner.remove(channelPartner);
    }

    public ChannelPartner update(ChannelPartner channelPartner){
        ChannelPartner toDelete = findChannelPartner(channelPartner.getChannelPartnerId());
        if(toDelete != null) {
            this.channelPartner.remove(toDelete);
            return create(channelPartner);
        }
        return null;
    }


    public Set<ChannelPartner> getAll(){
        return this.channelPartner;
    }
}
