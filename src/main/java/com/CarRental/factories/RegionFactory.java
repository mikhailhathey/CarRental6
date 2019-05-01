package com.CarRental.factories;

import com.CarRental.domain.Region;

public class RegionFactory {

    public static Region buildRegion(String regionId, String regionName, String regionLocation)
    {
        Region region = new Region.Builder()
                .regionId(regionId)
                .regionName(regionName)
                .regionLocation(regionLocation)
                .build();
        return region;
    }
}