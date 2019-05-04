package com.CarRental.domain;

public class VehiclePurchasePrice {

    private String vehiclePurchasePriceId;
    private String vehicleYearModel;
    private String vehiclePrice;

    public String getVehiclePurchasePriceId() {
        return vehiclePurchasePriceId;
    }

    public void setVehiclePurchasePriceId(String vehiclePurchasePriceId) {
        this.vehiclePurchasePriceId = vehiclePurchasePriceId;
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

    private VehiclePurchasePrice(){

    }

    public VehiclePurchasePrice(Builder builder) {
        this.vehiclePurchasePriceId = builder.vehiclePurchasePriceId;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehiclePrice = builder.vehiclePrice;
    }

    public static class Builder{

        private String vehiclePurchasePriceId;
        private String vehicleYearModel;
        private String vehiclePrice;

        public Builder vehiclePurchasePriceId(String value)
        {
            this.vehiclePurchasePriceId = value;
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

        public VehiclePurchasePrice build(){

            return new VehiclePurchasePrice(this);
        }

        public Builder copy(VehiclePurchasePrice savedVehiclePurchasePrice) {
            this.vehiclePurchasePriceId = savedVehiclePurchasePrice.vehiclePurchasePriceId;
            this.vehicleYearModel = savedVehiclePurchasePrice.vehicleYearModel;
            this.vehiclePrice = savedVehiclePurchasePrice.vehiclePrice;

            return this;
        }
    }
}
