package com.CarRental.factories;

import com.CarRental.domain.Supplier;

public class SupplierFactory {

    public static Supplier buildSupplier(String supplierId, String supplierName, String supplierContact, String supplierEmail)
    {
        return new Supplier.Builder()
                .supplierId(supplierId)
                .supplierName(supplierName)
                .supplierContact(supplierContact)
                .supplierEmail(supplierEmail)
                .build();
    }
}
