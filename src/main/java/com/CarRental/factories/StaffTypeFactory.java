package com.CarRental.factories;

import com.CarRental.domain.StaffType;

public class StaffTypeFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static StaffType buildStaffType(String staffTypeId, String cell, String home, String email)
    {
        StaffType staffType = new StaffType.Builder()
                .staffTypeId(staffTypeId)
                .cell(cell)
                .home(home)
                .email(email)
                .build();
        return staffType;
    }
}
