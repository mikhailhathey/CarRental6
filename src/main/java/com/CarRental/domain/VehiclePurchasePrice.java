package com.CarRental.domain;

public class VehiclePurchasePrice {

    private String vehiclePurchasePriceId;
    private String vehicleVehiclePurchasePrice;
    private String vehicleYearModel;
    private String vehiclePurchasePrice;

    public String getVehiclePurchasePriceId() {
        return vehiclePurchasePriceId;
    }

    public void setVehiclePurchasePriceId(String vehiclePurchasePriceId) {
        this.vehiclePurchasePriceId = vehiclePurchasePriceId;
    }

    public String getVehicleVehiclePurchasePrice() {
        return vehicleVehiclePurchasePrice;
    }

    public void setVehicleVehiclePurchasePrice(String vehicleVehiclePurchasePrice) {
        this.vehicleVehiclePurchasePrice = vehicleVehiclePurchasePrice;
    }

    public String getVehicleYearModel() {
        return vehicleYearModel;
    }

    public void setVehicleYearModel(String vehicleYearModel) {
        this.vehicleYearModel = vehicleYearModel;
    }

    public String getVehiclePurchasePrice() {
        return vehiclePurchasePrice;
    }

    public void setVehiclePurchasePrice(String vehiclePurchasePrice) {
        this.vehiclePurchasePrice = vehiclePurchasePrice;
    }

    private VehiclePurchasePrice(){

    }

    public VehiclePurchasePrice(Builder builder) {
        this.vehiclePurchasePriceId = builder.vehiclePurchasePriceId;
        this.vehicleVehiclePurchasePrice = builder.vehicleVehiclePurchasePrice;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehiclePurchasePrice = builder.vehiclePurchasePrice;
    }

    public static class Builder{

        private String vehiclePurchasePriceId;
        private String vehicleVehiclePurchasePrice;
        private String vehicleYearModel;
        private String vehiclePurchasePrice;

        public Builder vehiclePurchasePriceId(String value)
        {
            this.vehiclePurchasePriceId = value;
            return this;
        }

        public Builder vehicleVehiclePurchasePrice(String value)
        {
            this.vehicleVehiclePurchasePrice = value;
            return this;
        }

        public Builder vehicleYearModel(String value)
        {
            this.vehicleYearModel = value;
            return this;
        }

        public Builder vehiclePurchasePrice(String value)
        {
            this.vehiclePurchasePrice = value;
            return this;
        }

        public VehiclePurchasePrice build(){

            return new VehiclePurchasePrice(this);
        }
    }
}
