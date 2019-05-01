package com.CarRental.domain;

public class RentalTerm {

    private String rentalTermId;
    private String rentalTermNumber;
    private String rentalTermClass;
    private String rentalTermDays;
    private String rentalTermContact;
    private String rentalTermBranch;

    //rentalTermId, rentalTermNumber, rentalTermClass, rentalTermDays, rentalTermContact, rentalTermBranch
    public String getRentalId() {
        return rentalTermId;
    }

    public void setId(String rentalTermId) {
        this.rentalTermId = rentalTermId;
    }

    public String getRentalNumber() {
        return rentalTermNumber;
    }

    public void setRentalNumber(String rentalTermNumber) {
        this.rentalTermNumber = rentalTermNumber;
    }

    public String getRentalClass() {
        return rentalTermClass;
    }

    public void setRentalClass(String rentalTermClass) {
        this.rentalTermClass = rentalTermClass;
    }

    public String getRentalDays() {
        return rentalTermDays;
    }

    public void setRentalDays(String rentalTermDays) {
        this.rentalTermDays = rentalTermDays;
    }

    public String getRentalContact() {
        return rentalTermContact;
    }

    public void setRentalContact(String rentalTermContact) {
        this.rentalTermContact = rentalTermContact;
    }

    public String getRentalBranch() {
        return rentalTermBranch;
    }

    public void setRentalBranch(String rentalTermBranch) {
        this.rentalTermBranch = rentalTermBranch;
    }

    private RentalTerm(){

    }

    public RentalTerm(Builder builder) {
        this.rentalTermId = builder.rentalTermId;
        this.rentalTermNumber = builder.rentalTermNumber;
        this.rentalTermClass = builder.rentalTermClass;
        this.rentalTermDays = builder.rentalTermDays;
        this.rentalTermContact = builder.rentalTermContact;
        this.rentalTermBranch = builder.rentalTermBranch;
    }

    public static class Builder{

        private String rentalTermId;
        private String rentalTermNumber;
        private String rentalTermClass;
        private String rentalTermDays;
        private String rentalTermContact;
        private String rentalTermBranch;

        public Builder rentalTermId(String value)
        {
            this.rentalTermId = value;
            return this;
        }

        public Builder rentalTermNumber(String value)
        {
            this.rentalTermNumber = value;
            return this;
        }

        public Builder rentalTermClass(String value)
        {
            this.rentalTermClass = value;
            return this;
        }

        public Builder rentalTermDays(String value)
        {
            this.rentalTermDays = value;
            return this;
        }

        public Builder rentalTermContact(String value)
        {
            this.rentalTermContact = value;
            return this;
        }

        public Builder rentalTermBranch(String value)
        {
            this.rentalTermBranch = value;
            return this;
        }

        public RentalTerm build(){

            return new RentalTerm(this);
        }
    }
}
