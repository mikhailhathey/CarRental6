package com.CarRental.service;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.factories.ChannelPartnerFactory;
import com.CarRental.repositories.impl.ChannelPartnerRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class ChannelPartnerServiceTest {

    private ChannelPartnerRepositoryImpl repository;
    private ChannelPartner channelPartner;


    @Before
    public void setUp() throws Exception {
        this.repository = ChannelPartnerRepositoryImpl.getRepository();
        this.channelPartner = ChannelPartnerFactory.buildChannelPartner("1234", "Microsoft", "John", "john@microsoft.com");
    }

    @Test
    public void getAll() {
        Set<ChannelPartner> channelPartner = this.repository.getAll();
        System.out.println("In getall, all = " + channelPartner);
    }

}
