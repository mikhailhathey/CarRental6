package com.CarRental.domain;

public class Admin {

    private String adminId;
    private String adminName;
    private String adminPassword;

    public String getAdminId() {
        return adminId;
    }

    public String getName() {
        return adminName;
    }

    public String getPassword() {
        return adminPassword;
    }

    private Admin() {
    }

    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.adminPassword = builder.adminPassword;
    }

    public static class Builder{
        private String adminId;
        private String adminName;
        private String adminPassword;

        public Builder adminId(String value){
            this.adminId = value;
            return this;
        }

        public Builder adminName(String value){
            this.adminName = value;
            return this;
        }

        public Builder adminPassword(String value){
            this.adminPassword = value;
            return this;
        }

        public Admin build(){

            return new Admin(this);
        }

        public Builder copy(Admin savedAdmin) {
            this.adminId = savedAdmin.adminId;
            this.adminName = savedAdmin.adminName;
            this.adminPassword = savedAdmin.adminPassword;

            return this;
        }
    }
}
