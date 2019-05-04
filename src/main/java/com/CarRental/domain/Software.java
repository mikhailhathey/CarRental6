package com.CarRental.domain;

public class Software {

    private String softwareId;
    private String softwareName;
    private String softwareVersion;
    private String softwarePrice;

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


    private Software(){

    }

    public Software(Builder builder) {
        this.softwareId = builder.softwareId;
        this.softwareName = builder.softwareName;
        this.softwareVersion = builder.softwareVersion;
        this.softwarePrice = builder.softwarePrice;
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
