package com.CarRental.domain;

public class Perishables {

    private String perishablesId;
    private String perishableName;
    private String perishableExpiryDate;
    private String perishableQuantity;

    public String getPerishablesId() {
        return perishablesId;
    }

    public void setPerishablesId(String perishablesId) {
        this.perishablesId = perishablesId;
    }

    public String getPerishableName() {
        return perishableName;
    }

    public void setPerishableName(String perishableName) {
        this.perishableName = perishableName;
    }

    public String getPerishableExpiryDate() {
        return perishableExpiryDate;
    }

    public void setPerishableExpiryDate(String perishableExpiryDate) {
        this.perishableExpiryDate = perishableExpiryDate;
    }

    public String getPerishableQuantity() {
        return perishableQuantity;
    }

    public void setPerishableQuantity(String perishableQuantity) {
        this.perishableQuantity = perishableQuantity;
    }


    private Perishables(){

    }

    public Perishables(Builder builder) {
        this.perishablesId = builder.perishablesId;
        this.perishableName = builder.perishableName;
        this.perishableExpiryDate = builder.perishableExpiryDate;
        this.perishableQuantity = builder.perishableQuantity;
    }

    public static class Builder{

        private String perishablesId;
        private String perishableName;
        private String perishableExpiryDate;
        private String perishableQuantity;

        public Builder perishablesId(String value)
        {
            this.perishablesId = value;
            return this;
        }

        public Builder perishableName(String value)
        {
            this.perishableName = value;
            return this;
        }

        public Builder perishableExpiryDate(String value)
        {
            this.perishableExpiryDate = value;
            return this;
        }

        public Builder perishableQuantity(String value)
        {
            this.perishableQuantity = value;
            return this;
        }

        public Perishables build(){

            return new Perishables(this);
        }
    }
}
