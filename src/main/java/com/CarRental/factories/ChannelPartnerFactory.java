package com.CarRental.factories;

import com.CarRental.domain.ChannelPartner;

public class ChannelPartnerFactory {

    public static ChannelPartner buildChannelPartner(String channelPartnerId, String channelPartnerName, String channelPartnerContact, String channelPartnerEmail)
    {
        ChannelPartner channelPartner = new ChannelPartner.Builder()
                .channelPartnerId(channelPartnerId)
                .channelPartnerName(channelPartnerName)
                .channelPartnerContact(channelPartnerContact)
                .channelPartnerEmail(channelPartnerEmail)
                .build();
        return channelPartner;
    }
}