package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class VehicleSellingPrice implements Comparable<VehicleSellingPrice>{

    @Id
    private String vehicleSellingPriceId;
    private String vehicleYearModel;
    private String vehiclePrice;

    private VehicleSellingPrice(){
    }

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

    public VehicleSellingPrice(Builder builder) {
        this.vehicleSellingPriceId = builder.vehicleSellingPriceId;
        this.vehicleYearModel = builder.vehicleYearModel;
        this.vehiclePrice = builder.vehiclePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleSellingPrice)) return false;
        VehicleSellingPrice vehicleSellingPrice = (VehicleSellingPrice) o;
        return getVehicleSellingPriceId().equals(vehicleSellingPrice.getVehicleSellingPriceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleSellingPriceId());
    }

    @Override
    public String toString() {
        return "VehicleSellingPrice{" +
                "vehicleSellingPriceId='" + vehicleSellingPriceId + '\'' +
                ", vehicleYearModel='" + vehicleYearModel + '\'' +
                ", vehiclePrice='" + vehiclePrice + '\'' +
                '}';
    }

    @Override
    public int compareTo(VehicleSellingPrice vehicleSellingPrice) {
        return this.vehicleSellingPriceId.compareTo(vehicleSellingPrice.vehicleSellingPriceId);
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

        public Builder copy(VehicleSellingPrice savedVehicleSellingPrice) {
            this.vehicleSellingPriceId = savedVehicleSellingPrice.vehicleSellingPriceId;
            this.vehicleYearModel = savedVehicleSellingPrice.vehicleYearModel;
            this.vehiclePrice = savedVehicleSellingPrice.vehiclePrice;

            return this;
        }
    }
}
