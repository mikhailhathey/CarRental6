package com.CarRental.factories;

import com.CarRental.domain.Staff;

public class StaffFactory {

    //Changes to be made, in future iteration remove String staffId and have the String staffId generated.
    public static Staff buildStaff(String staffId, String cell, String home, String email)
    {
        Staff staff = new Staff.Builder()
                .staffId(staffId)
                .cell(cell)
                .home(home)
                .email(email)
                .build();
        return staff;
    }
}
