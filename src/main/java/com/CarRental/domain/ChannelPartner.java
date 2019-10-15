package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ChannelPartner implements Comparable<ChannelPartner> {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer channelPartnerId;
    private String channelPartnerName;
    private String channelPartnerContact;
    private String channelPartnerEmail;

    private ChannelPartner() {
    }

    public ChannelPartner(Builder builder) {
        this.channelPartnerId = builder.channelPartnerId;
        this.channelPartnerName = builder.channelPartnerName;
        this.channelPartnerContact = builder.channelPartnerContact;
        this.channelPartnerEmail = builder.channelPartnerEmail;
    }

    public Integer getChannelPartnerId() {
        return channelPartnerId;
    }

    public void setChannelPartnerId(Integer channelPartnerId) {
        this.channelPartnerId = channelPartnerId;
    }

    public String getChannelPartnerName() {
        return channelPartnerName;
    }

    public void setChannelPartnerName(String channelPartnerName) {
        this.channelPartnerName = channelPartnerName;
    }

    public String getChannelPartnerContact() {
        return channelPartnerContact;
    }

    public void setChannelPartnerContact(String channelPartnerContact) {
        this.channelPartnerContact = channelPartnerContact;
    }

    public String getChannelPartnerEmail() {
        return channelPartnerEmail;
    }

    public void setChannelPartnerEmail(String channelPartnerEmail) {
        this.channelPartnerEmail = channelPartnerEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChannelPartnerId());
    }

    @Override
    public String toString() {
        return "ChannelPartner{" +
                "channelPartnerId='" + channelPartnerId + '\'' +
                ", channelPartnerName='" + channelPartnerName + '\'' +
                ", channelPartnerContact='" + channelPartnerContact + '\'' +
                ", channelPartnerEmail='" + channelPartnerEmail + '\'' +
                '}';
    }

    @Override
    public int compareTo(ChannelPartner channelPartner) {
        return this.channelPartnerId.compareTo(channelPartner.channelPartnerId);
    }

    public static class Builder{

        private Integer channelPartnerId;
        private String channelPartnerName;
        private String channelPartnerContact;
        private String channelPartnerEmail;

        public Builder channelPartnerId(Integer value){
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
