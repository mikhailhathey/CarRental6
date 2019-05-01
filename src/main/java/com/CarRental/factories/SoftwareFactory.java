package com.CarRental.factories;

import com.CarRental.domain.Software;

public class SoftwareFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static Software buildContact(String softwareId, String cell, String home, String email)
    {
        Software software = new Software.Builder()
                .softwareId(softwareId)
                .cell(cell)
                .home(home)
                .email(email)
                .build();
        return software;
    }
}
