package com.CarRental.domain;

public class VehicleSellingPrice {

    private String vehicleSellingPriceId;
    private String vehicleYearModel;
    private String vehiclePrice;

    public String getVehicleSellingPriceId() {
        return vehicleSellingPriceId;
    }

    public void setVehicleSellingPriceId(String vehicleSellingPriceId) {
        this.vehicleSellingPriceId = vehicleSellingPriceId;
    }

    public String getVehicleYearModel() {
        return vehicleYearModel;
    }

    public void setVehicleYearModel(String vehicleYearModel) {
        this.vehicleYearModel = vehicleYearModel;
    }

    public String getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(String vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    private VehicleSellingPrice(){

    }

    public VehicleSellingPrice(Builder builder) {
        this.vehicleSellingPriceId = builder.vehicleSellingPriceId;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehiclePrice = builder.vehiclePrice;
    }

    public static class Builder{

        private String vehicleSellingPriceId;
        private String vehicleYearModel;
        private String vehiclePrice;

        public Builder vehicleSellingPriceId(String value)
        {
            this.vehicleSellingPriceId = value;
            return this;
        }

        public Builder vehicleYearModel(String value)
        {
            this.vehicleYearModel = value;
            return this;
        }

        public Builder vehiclePrice(String value)
        {
            this.vehiclePrice = value;
            return this;
        }

        public VehicleSellingPrice build(){

            return new VehicleSellingPrice(this);
        }
    }
}
