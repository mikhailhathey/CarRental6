package com.CarRental.domain;

public class Hardware {

    private String hardwareId;
    private String vinNumber;
    private String manufacturerName;
    private String modelName;
    private String yearModel;
    private String city;

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getYearModel() {
        return yearModel;
    }

    public void setYearModel(String yearModel) {
        this.yearModel = yearModel;
    }


    private Hardware(){

    }

    public Hardware(Builder builder) {
        this.hardwareId = builder.hardwareId;
        this.vinNumber = builder.vinNumber;
        this.manufacturerName = builder.manufacturerName;
        this.modelName = builder.modelName;
        this.yearModel = builder.yearModel;
    }

    public static class Builder{

        private String hardwareId;
        private String vinNumber;
        private String manufacturerName;
        private String modelName;
        private String yearModel;

        public Builder hardwareId(String value)
        {
            this.hardwareId = value;
            return this;
        }

        public Builder vinNumber(String value)
        {
            this.vinNumber = value;
            return this;
        }

        public Builder manufacturerName(String value)
        {
            this.manufacturerName = value;
            return this;
        }

        public Builder modelName(String value)
        {
            this.modelName = value;
            return this;
        }

        public Builder yearModel(String value)
        {
            this.yearModel = value;
            return this;
        }

        public Hardware build(){

            return new Hardware(this);
        }
    }
}
