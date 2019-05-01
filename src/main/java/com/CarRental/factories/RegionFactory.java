package com.CarRental.factories;

import com.CarRental.domain.Region;

public class RegionFactory {

    public static Region buildRegion(String regionId, String vinNumber, String manufacturerName, String modelName, String yearModel, String city)
    {
        Region region = new Region.Builder()
                .regionId(regionId)
                .vinNumber(vinNumber)
                .manufacturerName(manufacturerName)
                .modelName(modelName)
                .yearModel(yearModel)
                .build();
        return region;
    }
}