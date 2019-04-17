package com.CarRental.factories;

import com.CarRental.domain.Admin;

public class AdminFactory {

    public static Admin buildAdmin(String id, String name, String password)
    {
        Admin admin = new Admin.Builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
        return admin;
    }
}
