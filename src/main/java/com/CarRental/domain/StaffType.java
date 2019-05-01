package com.CarRental.domain;

public class StaffType {

    private String staffTypeId;
    private String staffTypeJobRole;
    private String staffTypeJobRoleSalary;

    public String getStaffTypeId() {
        return staffTypeId;
    }

    public void setStaffTypeId(String staffTypeId) {
        this.staffTypeId = staffTypeId;
    }

    public String getStaffTypeJobRole() {
        return staffTypeJobRole;
    }

    public void setStaffTypeJobRole(String staffTypeJobRole) {
        this.staffTypeJobRole = staffTypeJobRole;
    }

    public String getStaffTypeJobRoleSalary() {
        return staffTypeJobRoleSalary;
    }

    public void setStaffTypeJobRoleSalary(String staffTypeJobRoleSalary) {
        this.staffTypeJobRoleSalary = staffTypeJobRoleSalary;
    }

    private StaffType(){

    }

    public StaffType(Builder builder) {
        this.staffTypeId = builder.staffTypeId;
        this.staffTypeJobRole = builder.staffTypeJobRole;
        this.staffTypeJobRoleSalary = builder.staffTypeJobRoleSalary;
    }

    public static class Builder{

        private String staffTypeId;
        private String staffTypeJobRole;
        private String staffTypeJobRoleSalary;

        public Builder staffTypeId(String value)
        {
            this.staffTypeId = value;
            return this;
        }

        public Builder staffTypeJobRole(String value)
        {
            this.staffTypeJobRole = value;
            return this;
        }

        public Builder staffTypeJobRoleSalary(String value)
        {
            this.staffTypeJobRoleSalary = value;
            return this;
        }

        public StaffType build(){

            return new StaffType(this);
        }
    }
}
