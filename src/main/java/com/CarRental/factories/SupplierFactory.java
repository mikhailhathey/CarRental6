package com.CarRental.factories;

import com.CarRental.domain.Supplier;

public class SupplierFactory {

    public static Supplier buildSupplier(String supplierId, String vinNumber, String manufacturerName, String modelName, String yearModel, String city)
    {
        Supplier supplier = new Supplier.Builder()
                .supplierId(supplierId)
                .vinNumber(vinNumber)
                .manufacturerName(manufacturerName)
                .modelName(modelName)
                .yearModel(yearModel)
                .build();
        return supplier;
    }
}