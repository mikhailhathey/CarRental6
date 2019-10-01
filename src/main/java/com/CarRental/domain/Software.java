package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Software implements Comparable<Software>{

    @Id
    private String softwareId;
    private String softwareName;
    private String softwareVersion;
    private String softwarePrice;

    private Software(){
    }

    public String getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(String softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getSoftwarePrice() {
        return softwarePrice;
    }

    public void setSoftwarePrice(String softwarePrice) {
        this.softwarePrice = softwarePrice;
    }

    public Software(Builder builder) {
        this.softwareId = builder.softwareId;
        this.softwareName = builder.softwareName;
        this.softwareVersion = builder.softwareVersion;
        this.softwarePrice = builder.softwarePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Software)) return false;
        Software software = (Software) o;
        return getSoftwareId().equals(software.getSoftwareId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSoftwareId());
    }

    @Override
    public String toString() {
        return "Software{" +
                "softwareId='" + softwareId + '\'' +
                ", softwareName='" + softwareName + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", softwarePrice='" + softwarePrice + '\'' +
                '}';
    }

    @Override
    public int compareTo(Software software) {
        return this.softwareId.compareTo(software.softwareId);
    }

    public static class Builder{

        private String softwareId;
        private String softwareName;
        private String softwareVersion;
        private String softwarePrice;

        public Builder softwareId(String value)
        {
            this.softwareId = value;
            return this;
        }

        public Builder softwareName(String value)
        {
            this.softwareName = value;
            return this;
        }

        public Builder softwareVersion(String value)
        {
            this.softwareVersion = value;
            return this;
        }

        public Builder softwarePrice(String value)
        {
            this.softwarePrice = value;
            return this;
        }

        public Software build(){

            return new Software(this);
        }

        public Builder copy(Software savedSoftware) {
            this.softwareId = savedSoftware.softwareId;
            this.softwareName = savedSoftware.softwareName;
            this.softwareVersion = savedSoftware.softwareVersion;
            this.softwarePrice = savedSoftware.softwarePrice;

            return this;
        }
    }
}
