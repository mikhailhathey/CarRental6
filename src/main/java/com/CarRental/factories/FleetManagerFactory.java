package com.CarRental.factories;

import com.CarRental.domain.FleetManager;

public class FleetManagerFactory {

    public static FleetManager buildFleetManager(Integer fleetManagerId, String fleetManagerNumber, String fleetManagerClass, String fleetManagerDays, String fleetManagerContact, String fleetManagerBranch)
    {
        return new FleetManager.Builder()
                .fleetManagerId(fleetManagerId)
                .fleetManagerNumber(fleetManagerNumber)
                .fleetManagerClass(fleetManagerClass)
                .fleetManagerDays(fleetManagerDays)
                .fleetManagerContact(fleetManagerContact)
                .fleetManagerBranch(fleetManagerBranch)
                .build();
    }
}
