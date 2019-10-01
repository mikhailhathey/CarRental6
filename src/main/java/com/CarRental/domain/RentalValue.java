package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RentalValue implements Comparable<RentalValue>{

    @Id
    private String rentalValueId;
    private String rentalValueClass;
    private String rentalValueAmount;

    private RentalValue() {
    }

    public String getRentalValueId() {
        return rentalValueId;
    }

    public void setRentalValueId(String rentalValueId) {
        this.rentalValueId = rentalValueId;
    }

    public String getRentalValueClass() {
        return rentalValueClass;
    }

    public void setRentalValueClass(String rentalValueClass) {
        this.rentalValueClass = rentalValueClass;
    }

    public String getRentalValueAmount() {
        return rentalValueAmount;
    }

    public void setRentalValueAmount(String rentalValueAmount) {
        this.rentalValueAmount = rentalValueAmount;
    }

    public RentalValue(Builder builder) {
        this.rentalValueId = builder.rentalValueId;
        this.rentalValueClass = builder.rentalValueClass;
        this.rentalValueAmount = builder.rentalValueAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalValue)) return false;
        RentalValue rentalValue = (RentalValue) o;
        return getRentalValueId().equals(rentalValue.getRentalValueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRentalValueId());
    }

    @Override
    public String toString() {
        return "RentalValue{" +
                "rentalValueId='" + rentalValueId + '\'' +
                ", rentalValueClass='" + rentalValueClass + '\'' +
                ", rentalValueAmount='" + rentalValueAmount + '\'' +
                '}';
    }

    @Override
    public int compareTo(RentalValue rentalValue) {
        return this.rentalValueId.compareTo(rentalValue.rentalValueId);
    }

    public static class Builder{
        private String rentalValueId;
        private String rentalValueClass;
        private String rentalValueAmount;

        public Builder rentalValueId(String value){
            this.rentalValueId = value;
            return this;
        }

        public Builder rentalValueClass(String value){
            this.rentalValueClass = value;
            return this;
        }

        public Builder rentalValueAmount(String value){
            this.rentalValueAmount = value;
            return this;
        }

        public RentalValue build(){

            return new RentalValue(this);
        }

        public Builder copy(RentalValue savedRentalValue) {
            this.rentalValueId = savedRentalValue.rentalValueId;
            this.rentalValueClass = savedRentalValue.rentalValueClass;
            this.rentalValueAmount = savedRentalValue.rentalValueAmount;

            return this;
        }
    }
}
