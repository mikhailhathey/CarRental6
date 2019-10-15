package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RentalTerm implements Comparable<RentalTerm>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer rentalTermId;
    private String rentalTermNumber;
    private String rentalTermClass;
    private String rentalTermDays;
    private String rentalTermContact;
    private String rentalTermBranch;

    private RentalTerm(){
    }

    //rentalTermId, rentalTermNumber, rentalTermClass, rentalTermDays, rentalTermContact, rentalTermBranch
    public Integer getRentalTermId() {
        return rentalTermId;
    }

    public void setRentalTermId(Integer rentalTermId) {
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

    public RentalTerm(Builder builder) {
        this.rentalTermId = builder.rentalTermId;
        this.rentalTermNumber = builder.rentalTermNumber;
        this.rentalTermClass = builder.rentalTermClass;
        this.rentalTermDays = builder.rentalTermDays;
        this.rentalTermContact = builder.rentalTermContact;
        this.rentalTermBranch = builder.rentalTermBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalTerm)) return false;
        RentalTerm rentalTerm = (RentalTerm) o;
        return getRentalTermId().equals(rentalTerm.getRentalTermId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRentalTermId());
    }

    @Override
    public String toString() {
        return "RentalTerm{" +
                "rentalTermId='" + rentalTermId + '\'' +
                ", rentalTermNumber='" + rentalTermNumber + '\'' +
                ", rentalTermClass='" + rentalTermClass + '\'' +
                ", rentalTermDays='" + rentalTermDays + '\'' +
                ", rentalTermContact='" + rentalTermContact + '\'' +
                ", rentalTermBranch='" + rentalTermBranch + '\'' +
                '}';
    }

    @Override
    public int compareTo(RentalTerm rentalTerm) {
        return this.rentalTermId.compareTo(rentalTerm.rentalTermId);
    }

    public static class Builder{

        private Integer rentalTermId;
        private String rentalTermNumber;
        private String rentalTermClass;
        private String rentalTermDays;
        private String rentalTermContact;
        private String rentalTermBranch;

        public Builder rentalTermId(Integer value)
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

        public Builder copy(RentalTerm savedRentalTerm) {
            this.rentalTermId = savedRentalTerm.rentalTermId;
            this.rentalTermNumber = savedRentalTerm.rentalTermNumber;
            this.rentalTermClass = savedRentalTerm.rentalTermClass;
            this.rentalTermDays = savedRentalTerm.rentalTermDays;
            this.rentalTermContact = savedRentalTerm.rentalTermContact;
            this.rentalTermBranch = savedRentalTerm.rentalTermBranch;

            return this;
        }
    }
}
