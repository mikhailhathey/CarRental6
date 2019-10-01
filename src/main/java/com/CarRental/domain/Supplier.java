package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Supplier implements Comparable<Supplier>{

    @Id
    private String supplierId;
    private String supplierName;
    private String supplierContact;
    private String supplierEmail;

    private Supplier(){
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.supplierContact = builder.supplierContact;
        this.supplierEmail = builder.supplierEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return getSupplierId().equals(supplier.getSupplierId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSupplierId());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierContact='" + supplierContact + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                '}';
    }

    @Override
    public int compareTo(Supplier supplier) {
        return this.supplierId.compareTo(supplier.supplierId);
    }

    public static class Builder{

        private String supplierId;
        private String supplierName;
        private String supplierContact;
        private String supplierEmail;

        public Builder supplierId(String value)
        {
            this.supplierId = value;
            return this;
        }

        public Builder supplierName(String value)
        {
            this.supplierName = value;
            return this;
        }

        public Builder supplierContact(String value)
        {
            this.supplierContact = value;
            return this;
        }

        public Builder supplierEmail(String value)
        {
            this.supplierEmail = value;
            return this;
        }

        public Supplier build(){

            return new Supplier(this);
        }

        public Builder copy(Supplier savedSupplier) {
            this.supplierId = savedSupplier.supplierId;
            this.supplierName = savedSupplier.supplierName;
            this.supplierContact = savedSupplier.supplierContact;
            this.supplierEmail = savedSupplier.supplierEmail;

            return this;
        }
    }
}
