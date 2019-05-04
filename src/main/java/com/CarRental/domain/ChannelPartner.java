package com.CarRental.domain;

public class ChannelPartner {


    private String channelPartnerId;
    private String channelPartnerName;
    private String channelPartnerContact;
    private String channelPartnerEmail;

    public String getChannelPartnerId() {
        return channelPartnerId;
    }

    public String getChannelPartnerName() {
        return channelPartnerName;
    }

    public String getChannelPartnerContact() {
        return channelPartnerContact;
    }

    public String getChannelPartnerEmail() {
        return channelPartnerEmail;
    }

    private ChannelPartner() {
    }

    public ChannelPartner(Builder builder) {
        this.channelPartnerId = builder.channelPartnerId;
        this.channelPartnerName = builder.channelPartnerName;
        this.channelPartnerContact = builder.channelPartnerContact;
        this.channelPartnerEmail = builder.channelPartnerEmail;
    }

    public static class Builder{

        private String channelPartnerId;
        private String channelPartnerName;
        private String channelPartnerContact;
        private String channelPartnerEmail;

        public Builder channelPartnerId(String value){
            this.channelPartnerId = value;
            return this;
        }

        public Builder channelPartnerName(String value){
            this.channelPartnerName = value;
            return this;
        }

        public Builder channelPartnerContact(String value){
            this.channelPartnerContact = value;
            return this;
        }

        public Builder channelPartnerEmail(String value){
            this.channelPartnerEmail = value;
            return this;
        }

        public ChannelPartner build(){

            return new ChannelPartner(this);
        }

        public Builder copy(ChannelPartner savedChannelPartner) {
            this.channelPartnerId = savedChannelPartner.channelPartnerId;
            this.channelPartnerName = savedChannelPartner.channelPartnerName;
            this.channelPartnerContact = savedChannelPartner.channelPartnerContact;
            this.channelPartnerEmail = savedChannelPartner.channelPartnerEmail;

            return this;
        }
    }
}
