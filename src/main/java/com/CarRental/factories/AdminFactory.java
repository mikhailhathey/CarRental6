package com.CarRental.factories;

import com.CarRental.domain.Admin;

public class AdminFactory {

    public static Admin buildAdmin(String adminId, String adminName, String adminPassword)
    {
        Admin admin = new Admin.Builder()
                .adminId(adminId)
                .adminName(adminName)
                .adminPassword(adminPassword)
                .build();
        return admin;
    }
}
