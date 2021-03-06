package com.CarRental.factories;

import com.CarRental.domain.Admin;

public class AdminFactory {

    public static Admin buildAdmin(Integer adminId, String adminName, String adminPassword)
    {
        return new Admin.Builder()
                .adminId(adminId)
                .adminName(adminName)
                .adminPassword(adminPassword)
                .build();
    }
}
