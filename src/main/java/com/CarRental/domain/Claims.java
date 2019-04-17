package com.CarRental.domain;

public class Contact {


    private String id;
    private String cell;
    private String home;
    private String email;

    public String getId() {
        return id;
    }

    public String getCell() {
        return cell;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    private Contact() {
    }

    public Contact(Builder builder) {
        this.id = builder.id;
        this.cell = builder.cell;
        this.home = builder.home;
        this.email = builder.email;
    }

    public static class Builder{

        private String id;
        private String cell;
        private String home;
        private String email;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder cell(String value){
            this.cell = value;
            return this;
        }

        public Builder home(String value){
            this.home = value;
            return this;
        }

        public Builder email(String value){
            this.email = value;
            return this;
        }

        public Contact build(){

            return new Contact(this);
        }

    }
}
