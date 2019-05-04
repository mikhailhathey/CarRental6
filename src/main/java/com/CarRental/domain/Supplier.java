package com.CarRental.domain;

public class Supplier {

    private String supplierId;
    private String supplierName;
    private String supplierContact;
    private String supplierEmail;

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

    private Supplier(){

    }

    public Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.supplierContact = builder.supplierContact;
        this.supplierEmail = builder.supplierEmail;
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
