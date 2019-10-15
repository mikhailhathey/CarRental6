package com.CarRental.factories;

import com.CarRental.domain.Staff;

public class StaffFactory {

    //Changes to be made, in future iteration remove String staffId and have the String staffId generated.
    public static Staff buildStaff(Integer staffId, String staffName, String staffContact, String staffEmail, String staffIDNumber)
    {
        return new Staff.Builder()
                .staffId(staffId)
                .staffName(staffName)
                .staffContact(staffContact)
                .staffEmail(staffEmail)
                .staffIDNumber(staffIDNumber)
                .build();
    }
}
