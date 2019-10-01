package com.CarRental.factories;

import com.CarRental.domain.StaffType;

public class StaffTypeFactory {

    //Changes to be made, in future iteration remove String id and have the String id generated.
    public static StaffType buildStaffType(String staffTypeId, String staffTypeJobRole, String staffTypeJobRoleSalary)
    {
        return new StaffType.Builder()
                .staffTypeId(staffTypeId)
                .staffTypeJobRole(staffTypeJobRole)
                .staffTypeJobRoleSalary(staffTypeJobRoleSalary)
                .build();
    }
}
