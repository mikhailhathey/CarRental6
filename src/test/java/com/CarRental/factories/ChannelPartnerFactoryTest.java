package com.CarRental.factories;

import com.CarRental.domain.ChannelPartner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChannelPartnerFactoryTest {

    private String ChannelPartnerTest;

    @Before
    public void setUp() throws Exception {
        this.ChannelPartnerTest = "ChanelPartnerTest";
    }

    @Test
    public void buildCar() {
        ChannelPartner channelPartner = ChannelPartnerFactory.buildChannelPartner(1234, "Microsoft", "John", "john@microsoft.com");
        System.out.println(channelPartner);
        Assert.assertNotNull(channelPartner.getChannelPartnerId());
    }
}