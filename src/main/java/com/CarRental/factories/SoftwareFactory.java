package com.CarRental.factories;

import com.CarRental.domain.Software;

public class SoftwareFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static Software buildSoftware(Integer softwareId, String softwareName, String softwareVersion, String softwarePrice)
    {
        return new Software.Builder()
                .softwareId(softwareId)
                .softwareName(softwareName)
                .softwareVersion(softwareVersion)
                .softwarePrice(softwarePrice)
                .build();
    }
}
