package com.CarRental.factories;

import com.CarRental.domain.Car;

public class SupplierFactory {

    public static Car buildCar(String carId, String vinNumber, String manufacturerName, String modelName, String yearModel, String city)
    {
        Car car = new Car.Builder()
                .carId(carId)
                .vinNumber(vinNumber)
                .manufacturerName(manufacturerName)
                .modelName(modelName)
                .yearModel(yearModel)
                .build();
        return car;
    }
}