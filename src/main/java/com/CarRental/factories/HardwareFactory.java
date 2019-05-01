package com.CarRental.factories;

import com.CarRental.domain.Hardware;

public class HardwareFactory {

    public static Hardware buildHardware(String hardwareId, String hardwareNumber, String hardwareClass, String hardwareDays, String hardwareContact, String hardwareBranch)
    {
        Hardware hardware = new Hardware.Builder()
                .hardwareId(hardwareId)
                .hardwareNumber(hardwareNumber)
                .hardwareClass(hardwareClass)
                .hardwareDays(hardwareDays)
                .hardwareContact(hardwareContact)
                .hardwareBranch(hardwareBranch)
                .build();
        return hardware;
    }
}