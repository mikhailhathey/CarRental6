package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StaffType implements Comparable<StaffType>{

    @Id
    private String staffTypeId;
    private String staffTypeJobRole;
    private String staffTypeJobRoleSalary;

    private StaffType(){
    }

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

    public StaffType(Builder builder) {
        this.staffTypeId = builder.staffTypeId;
        this.staffTypeJobRole = builder.staffTypeJobRole;
        this.staffTypeJobRoleSalary = builder.staffTypeJobRoleSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffType)) return false;
        StaffType staffType = (StaffType) o;
        return getStaffTypeId().equals(staffType.getStaffTypeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStaffTypeId());
    }

    @Override
    public String toString() {
        return "StaffType{" +
                "staffTypeId='" + staffTypeId + '\'' +
                ", staffTypeJobRole='" + staffTypeJobRole + '\'' +
                ", staffTypeJobRoleSalary='" + staffTypeJobRoleSalary + '\'' +
                '}';
    }

    @Override
    public int compareTo(StaffType staffType) {
        return this.staffTypeId.compareTo(staffType.staffTypeId);
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

        public Builder copy(StaffType savedStaffType) {
            this.staffTypeId = savedStaffType.staffTypeId;
            this.staffTypeJobRole = savedStaffType.staffTypeJobRole;
            this.staffTypeJobRoleSalary = savedStaffType.staffTypeJobRoleSalary;

            return this;
        }
    }
}
