package com.CarRental.domain;

public class RentalValue {

    private String rentalValueId;
    private String rentalValueClass;
    private String rentalValueAmount;

    public String getRentalValueId() {
        return rentalValueId;
    }

    public String getRentalValueClass() {
        return rentalValueClass;
    }

    public String getRentalValueAmount() {
        return rentalValueAmount;
    }

    private RentalValue() {
    }

    public RentalValue(Builder builder) {
        this.rentalValueId = builder.rentalValueId;
        this.rentalValueClass = builder.rentalValueClass;
        this.rentalValueAmount = builder.rentalValueAmount;
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
