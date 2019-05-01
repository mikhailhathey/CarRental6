package com.CarRental.repositories;

import com.CarRental.domain.ChannelPartner;

import java.util.Set;


public interface ChannelPartnerRepository extends CrudRepository<ChannelPartner, String> {

    Set<ChannelPartner> getAll();
    //public List<ChannelPartner> findByAge(int age);
    //public List<ChannelPartner> findById(String id);

}
