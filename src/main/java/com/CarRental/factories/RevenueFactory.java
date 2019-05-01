package com.CarRental.factories;

import com.CarRental.domain.Revenue;

public class RevenueFactory {

    public static Revenue buildRevenue(String revenueId, String name, String password)
    {
        Revenue revenue = new Revenue.Builder()
                .revenueId(revenueId)
                .name(name)
                .password(password)
                .build();
        return revenue;
    }
}
