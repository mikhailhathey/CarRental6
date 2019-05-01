package com.CarRental.factories;

import com.CarRental.domain.FleetManager;

public class FleetManagerFactory {

    public static FleetManager buildFleetManager(String id, String name, String password)
    {
        FleetManager fleetManager = new FleetManager.Builder()
                .fleetManagerId(id)
                .name(name)
                .password(password)
                .build();
        return fleetManager;
    }
}
