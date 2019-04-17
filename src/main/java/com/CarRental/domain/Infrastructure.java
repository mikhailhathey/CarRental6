package com.CarRental.domain;

public class Infrastructure {

    private String carId;
    private String vinNumber;
    private String manufacturerName;
    private String modelName;
    private String yearModel;
    private String city;

    public String getId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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


    private Car(){

    }

    public Car(Builder builder) {
        this.carId = builder.carId;
        this.vinNumber = builder.vinNumber;
        this.manufacturerName = builder.manufacturerName;
        this.modelName = builder.modelName;
        this.yearModel = builder.yearModel;
    }

    public static class Builder{

        private String carId;
        private String vinNumber;
        private String manufacturerName;
        private String modelName;
        private String yearModel;

        public Builder carId(String value)
        {
            this.carId = value;
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

        public Car build(){

            return new Car(this);
        }
    }
}
