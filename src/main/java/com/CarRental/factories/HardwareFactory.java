package com.CarRental.factories;

import com.CarRental.domain.Hardware;

public class HardwareFactory {

    public static Hardware buildHardware(String hardwareId, String hardwareName, String hardwarePrice)
    {
        Hardware hardware = new Hardware.Builder()
                .hardwareId(hardwareId)
                .hardwareName(hardwareName)
                .hardwarePrice(hardwarePrice)
                .build();
        return hardware;
    }
}