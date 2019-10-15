package com.CarRental.factories;

import com.CarRental.domain.Revenue;

public class RevenueFactory {

    public static Revenue buildRevenue(Integer revenueId, String revenueMonth, String revenuePeriod, String revenueAmount, String revenueBranch)
    {
        return new Revenue.Builder()
                .revenueId(revenueId)
                .revenueMonth(revenueMonth)
                .revenuePeriod(revenuePeriod)
                .revenueAmount(revenueAmount)
                .revenueBranch(revenueBranch)
                .build();
    }
}
