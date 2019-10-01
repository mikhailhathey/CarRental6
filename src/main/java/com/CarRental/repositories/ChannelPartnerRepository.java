package com.CarRental.repositories;

import com.CarRental.domain.ChannelPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelPartnerRepository extends JpaRepository<ChannelPartner, String> {

    //Set<ChannelPartner> getAll();
    //public List<ChannelPartner> findByAge(int age);
    //public List<ChannelPartner> findById(String id);

}
