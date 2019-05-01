package com.CarRental.factories;

import com.CarRental.domain.Profit;

public class ProfitFactory {

    public static Profit buildProfit(String profitId, String name, String password)
    {
        Profit profit = new Profit.Builder()
                .profitId(profitId)
                .name(name)
                .password(password)
                .build();
        return profit;
    }
}
