package com.CarRental.domain;

public class RentalTerm {

    private String rentalTermId;
    private String rentalTermNumber;
    private String rentalTermClass;
    private String rentalTermDays;
    private String rentalTermContact;
    private String rentalTermBranch;

    //rentalTermId, rentalTermNumber, rentalTermClass, rentalTermDays, rentalTermContact, rentalTermBranch
    public String getRentalTermId() {
        return rentalTermId;
    }

    public void setId(String rentalTermId) {
        this.rentalTermId = rentalTermId;
    }

    public String getRentalTermNumber() {
        return rentalTermNumber;
    }

    public void setRentalTermNumber(String rentalTermNumber) {
        this.rentalTermNumber = rentalTermNumber;
    }

    public String getRentalTermClass() {
        return rentalTermClass;
    }

    public void setRentalTermClass(String rentalTermClass) {
        this.rentalTermClass = rentalTermClass;
    }

    public String getRentalTermDays() {
        return rentalTermDays;
    }

    public void setRentalTermDays(String rentalTermDays) {
        this.rentalTermDays = rentalTermDays;
    }

    public String getRentalTermContact() {
        return rentalTermContact;
    }

    public void setRentalTermContact(String rentalTermContact) {
        this.rentalTermContact = rentalTermContact;
    }

    public String getRentalTermBranch() {
        return rentalTermBranch;
    }

    public void setRentalTermBranch(String rentalTermBranch) {
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
