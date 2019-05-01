package com.CarRental.domain;

public class Client {

    private String clientId;
    private String clientCell;
    private String clientName;
    private String clientEmail;
    private String clientWebsite;
    private String clientAddress;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientCell() {
        return clientCell;
    }

    public void setClientCell(String clientCell) {
        this.clientCell = clientCell;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientWebsite() {
        return clientWebsite;
    }

    public void setClientWebsite(String clientWebsite) {
        this.clientWebsite = clientWebsite;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    private Client(){

    }

    public Client(Builder builder) {
        this.clientId = builder.clientId;
        this.clientCell = builder.clientCell;
        this.clientName = builder.clientName;
        this.clientEmail = builder.clientEmail;
        this.clientWebsite = builder.clientWebsite;
        this.clientAddress = builder.clientAddress;
    }

    public static class Builder{

        private String clientId;
        private String clientCell;
        private String clientName;
        private String clientEmail;
        private String clientWebsite;
        private String clientAddress;

        public Builder clientId(String value)
        {
            this.clientId = value;
            return this;
        }

        public Builder clientCell(String value)
        {
            this.clientCell = value;
            return this;
        }

        public Builder clientName(String value)
        {
            this.clientName = value;
            return this;
        }

        public Builder clientEmail(String value)
        {
            this.clientEmail = value;
            return this;
        }

        public Builder clientWebsite(String value)
        {
            this.clientWebsite = value;
            return this;
        }

        public Builder clientAddress(String value)
        {
            this.clientAddress = value;
            return this;
        }

        public Client build(){

            return new Client(this);
        }
    }
}
