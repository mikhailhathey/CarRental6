package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client implements Comparable<Client>{

    @Id
    private String clientId;
    private String clientCell;
    private String clientName;
    private String clientEmail;
    private String clientWebsite;
    private String clientAddress;

    private Client(){
    }

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

    public String getClientClient() {
        return clientAddress;
    }

    public void setClientClient(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getClientId().equals(client.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId());
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", clientCell='" + clientCell + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientWebsite='" + clientWebsite + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                '}';
    }

    @Override
    public int compareTo(Client client) {
        return this.clientId.compareTo(client.clientId);
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

        public Builder copy(Client savedClient) {
            this.clientId = savedClient.clientId;
            this.clientCell = savedClient.clientCell;
            this.clientName = savedClient.clientName;
            this.clientEmail = savedClient.clientEmail;
            this.clientWebsite = savedClient.clientWebsite;
            this.clientAddress = savedClient.clientAddress;

            return this;
        }
    }
}
