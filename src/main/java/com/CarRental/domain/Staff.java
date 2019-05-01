package com.CarRental.domain;

public class Staff {

    private String staffId;
    private String staffName;
    private String staffContact;
    private String staffEmail;
    private String staffIDNumber;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffIDNumber() {
        return staffIDNumber;
    }

    public void setStaffIDNumber(String staffIDNumber) {
        this.staffIDNumber = staffIDNumber;
    }


    private Staff(){

    }

    public Staff(Builder builder) {
        this.staffId = builder.staffId;
        this.staffName = builder.staffName;
        this.staffContact = builder.staffContact;
        this.staffEmail = builder.staffEmail;
        this.staffIDNumber = builder.staffIDNumber;
    }

    public static class Builder{

        private String staffId;
        private String staffName;
        private String staffContact;
        private String staffEmail;
        private String staffIDNumber;

        public Builder staffId(String value)
        {
            this.staffId = value;
            return this;
        }

        public Builder staffName(String value)
        {
            this.staffName = value;
            return this;
        }

        public Builder staffContact(String value)
        {
            this.staffContact = value;
            return this;
        }

        public Builder staffEmail(String value)
        {
            this.staffEmail = value;
            return this;
        }

        public Builder staffIDNumber(String value)
        {
            this.staffIDNumber = value;
            return this;
        }

        public Staff build(){

            return new Staff(this);
        }
    }
}
