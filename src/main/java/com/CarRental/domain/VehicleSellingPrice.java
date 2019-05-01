package com.CarRental.domain;

public class VehicleSellingPrice {

    private String vehicleSellingPriceId;
    private String vehicleVehicleSellingPrice;
    private String vehicleYearModel;
    private String vehicleSellingPrice;

    public String getVehicleSellingPriceId() {
        return vehicleSellingPriceId;
    }

    public void setVehicleSellingPriceId(String vehicleSellingPriceId) {
        this.vehicleSellingPriceId = vehicleSellingPriceId;
    }

    public String getVehicleVehicleSellingPrice() {
        return vehicleVehicleSellingPrice;
    }

    public void setVehicleVehicleSellingPrice(String vehicleVehicleSellingPrice) {
        this.vehicleVehicleSellingPrice = vehicleVehicleSellingPrice;
    }

    public String getVehicleYearModel() {
        return vehicleYearModel;
    }

    public void setVehicleYearModel(String vehicleYearModel) {
        this.vehicleYearModel = vehicleYearModel;
    }

    public String getVehicleSellingPrice() {
        return vehicleSellingPrice;
    }

    public void setVehicleSellingPrice(String vehicleSellingPrice) {
        this.vehicleSellingPrice = vehicleSellingPrice;
    }

    private VehicleSellingPrice(){

    }

    public VehicleSellingPrice(Builder builder) {
        this.vehicleSellingPriceId = builder.vehicleSellingPriceId;
        this.vehicleVehicleSellingPrice = builder.vehicleVehicleSellingPrice;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehicleSellingPrice = builder.vehicleSellingPrice;
    }

    public static class Builder{

        private String vehicleSellingPriceId;
        private String vehicleVehicleSellingPrice;
        private String vehicleYearModel;
        private String vehicleSellingPrice;

        public Builder vehicleSellingPriceId(String value)
        {
            this.vehicleSellingPriceId = value;
            return this;
        }

        public Builder vehicleVehicleSellingPrice(String value)
        {
            this.vehicleVehicleSellingPrice = value;
            return this;
        }

        public Builder vehicleYearModel(String value)
        {
            this.vehicleYearModel = value;
            return this;
        }

        public Builder vehicleSellingPrice(String value)
        {
            this.vehicleSellingPrice = value;
            return this;
        }

        public VehicleSellingPrice build(){

            return new VehicleSellingPrice(this);
        }
    }
}
