package com.CarRental.factories;

import com.CarRental.domain.FleetManager;

public class FleetManagerFactory {

    public static FleetManager buildFleetManager(String fleetManagerId, String fleetManagerNumber, String fleetManagerClass, String fleetManagerDays, String fleetManagerContact, String fleetManagerBranch)
    {
        FleetManager fleetManager = new FleetManager.Builder()
                .fleetManagerId(fleetManagerId)
                .fleetManagerNumber(fleetManagerNumber)
                .fleetManagerClass(fleetManagerClass)
                .fleetManagerDays(fleetManagerDays)
                .fleetManagerContact(fleetManagerContact)
                .fleetManagerBranch(fleetManagerBranch)
                .build();
        return fleetManager;
    }
}
