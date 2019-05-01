package com.CarRental.domain;

public class Contact {


    private String contactId;
    private String contactCell;
    private String contactHome;
    private String contactEmail;

    public String getContactId() {
        return contactId;
    }

    public String getContactCell() {
        return contactCell;
    }

    public String getContactHome() {
        return contactHome;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    private Contact() {
    }

    public Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.contactCell = builder.contactCell;
        this.contactHome = builder.contactHome;
        this.contactEmail = builder.contactEmail;
    }

    public static class Builder{

        private String contactId;
        private String contactCell;
        private String contactHome;
        private String contactEmail;

        public Builder contactId(String value){
            this.contactId = value;
            return this;
        }

        public Builder contactCell(String value){
            this.contactCell = value;
            return this;
        }

        public Builder contactHome(String value){
            this.contactHome = value;
            return this;
        }

        public Builder contactEmail(String value){
            this.contactEmail = value;
            return this;
        }

        public Contact build(){

            return new Contact(this);
        }

    }
}
