package com.CarRental.domain;

public class Revenue {

    private String rentalId;
    private String rentalNumber;
    private String rentalClass;
    private String rentalDays;
    private String rentalContact;
    private String rentalBranch;

    //rentalId, rentalNumber, rentalClass, rentalDays, rentalContact, rentalBranch
    public String getRentalId() {
        return rentalId;
    }

    public vorentalId setId(String rentalId) {
        this.rentalId = rentalId;
    }

    public String getRentalNumber() {
        return rentalNumber;
    }

    public vorentalId setRentalNumber(String rentalNumber) {
        this.rentalNumber = rentalNumber;
    }

    public String getRentalClass() {
        return rentalClass;
    }

    public vorentalId setRentalClass(String rentalClass) {
        this.rentalClass = rentalClass;
    }

    public String getRentalDays() {
        return rentalDays;
    }

    public vorentalId setRentalDays(String rentalDays) {
        this.rentalDays = rentalDays;
    }

    public String getRentalContact() {
        return rentalContact;
    }

    public vorentalId setRentalContact(String rentalContact) {
        this.rentalContact = rentalContact;
    }

    public String getRentalBranch() {
        return rentalBranch;
    }

    public vorentalId setRentalBranch(String rentalBranch) {
        this.rentalBranch = rentalBranch;
    }

    private RentalTerm(){

    }

    public RentalTerm(Builder builder) {
        this.rentalId = builder.rentalId;
        this.rentalNumber = builder.rentalNumber;
        this.rentalClass = builder.rentalClass;
        this.rentalDays = builder.rentalDays;
        this.rentalContact = builder.rentalContact;
        this.rentalBranch = builder.rentalBranch;
    }

    public static class Builder{

        private String rentalId;
        private String rentalNumber;
        private String rentalClass;
        private String rentalDays;
        private String rentalContact;
        private String rentalBranch;

        public Builder rentalId(String value)
        {
            this.rentalId = value;
            return this;
        }

        public Builder rentalNumber(String value)
        {
            this.rentalNumber = value;
            return this;
        }

        public Builder rentalClass(String value)
        {
            this.rentalClass = value;
            return this;
        }

        public Builder rentalDays(String value)
        {
            this.rentalDays = value;
            return this;
        }

        public Builder rentalContact(String value)
        {
            this.rentalContact = value;
            return this;
        }

        public Builder rentalBranch(String value)
        {
            this.rentalBranch = value;
            return this;
        }

        public RentalTerm build(){

            return new RentalTerm(this);
        }
    }
}
