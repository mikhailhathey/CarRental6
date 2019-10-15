package com.CarRental.factories;

import com.CarRental.domain.Hardware;

public class HardwareFactory {

    public static Hardware buildHardware(Integer hardwareId, String hardwareName, String hardwarePrice)
    {
        return new Hardware.Builder()
                .hardwareId(hardwareId)
                .hardwareName(hardwareName)
                .hardwarePrice(hardwarePrice)
                .build();
    }
}
