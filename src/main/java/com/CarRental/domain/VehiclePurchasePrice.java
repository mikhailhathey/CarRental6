package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class VehiclePurchasePrice implements Comparable<VehiclePurchasePrice>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer vehiclePurchasePriceId;
    private String vehicleYearModel;
    private String vehiclePrice;

    private VehiclePurchasePrice(){
    }

    public Integer getVehiclePurchasePriceId() {
        return vehiclePurchasePriceId;
    }

    public void setVehiclePurchasePriceId(Integer vehiclePurchasePriceId) {
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

    public VehiclePurchasePrice(Builder builder) {
        this.vehiclePurchasePriceId = builder.vehiclePurchasePriceId;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehiclePrice = builder.vehiclePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehiclePurchasePrice)) return false;
        VehiclePurchasePrice vehiclePurchasePrice = (VehiclePurchasePrice) o;
        return getVehiclePurchasePriceId().equals(vehiclePurchasePrice.getVehiclePurchasePriceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehiclePurchasePriceId());
    }

    @Override
    public String toString() {
        return "VehiclePurchasePrice{" +
                "vehiclePurchasePriceId='" + vehiclePurchasePriceId + '\'' +
                ", vehicleYearModel='" + vehicleYearModel + '\'' +
                ", vehiclePrice='" + vehiclePrice + '\'' +
                '}';
    }

    @Override
    public int compareTo(VehiclePurchasePrice vehiclePurchasePrice) {
        return this.vehiclePurchasePriceId.compareTo(vehiclePurchasePrice.vehiclePurchasePriceId);
    }

    public static class Builder{

        private Integer vehiclePurchasePriceId;
        private String vehicleYearModel;
        private String vehiclePrice;

        public Builder vehiclePurchasePriceId(Integer value)
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
