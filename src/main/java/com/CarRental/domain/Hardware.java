package com.CarRental.domain;

public class Hardware {

    private String hardwareId;
    private String hardwareName;
    private String hardwarePrice;

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getHardwarePrice() {
        return hardwarePrice;
    }

    public void setHardwarePrice(String hardwarePrice) {
        this.hardwarePrice = hardwarePrice;
    }

    private Hardware(){

    }

    public Hardware(Builder builder) {
        this.hardwareId = builder.hardwareId;
        this.hardwareName = builder.hardwareName;
        this.hardwarePrice = builder.hardwarePrice;
    }

    public static class Builder{

        private String hardwareId;
        private String hardwareName;
        private String hardwarePrice;

        public Builder hardwareId(String value)
        {
            this.hardwareId = value;
            return this;
        }

        public Builder hardwareName(String value)
        {
            this.hardwareName = value;
            return this;
        }

        public Builder hardwarePrice(String value)
        {
            this.hardwarePrice = value;
            return this;
        }

        public Hardware build(){

            return new Hardware(this);
        }
    }
}
