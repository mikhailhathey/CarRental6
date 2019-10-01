package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Staff implements Comparable<Staff>{

    @Id
    private String staffId;
    private String staffName;
    private String staffContact;
    private String staffEmail;
    private String staffIDNumber;

    private Staff(){
    }

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

    public Staff(Builder builder) {
        this.staffId = builder.staffId;
        this.staffName = builder.staffName;
        this.staffContact = builder.staffContact;
        this.staffEmail = builder.staffEmail;
        this.staffIDNumber = builder.staffIDNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return getStaffId().equals(staff.getStaffId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStaffId());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffContact='" + staffContact + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffIDNumber='" + staffIDNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Staff staff) {
        return this.staffId.compareTo(staff.staffId);
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

        public Builder copy(Staff savedStaff) {
            this.staffId = savedStaff.staffId;
            this.staffName = savedStaff.staffName;
            this.staffContact = savedStaff.staffContact;
            this.staffEmail = savedStaff.staffEmail;
            this.staffIDNumber = savedStaff.staffIDNumber;

            return this;
        }
    }
}
