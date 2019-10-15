package com.CarRental.factories;

import com.CarRental.domain.Profit;

public class ProfitFactory {

    public static Profit buildProfit(Integer profitId, String profitProjected, String profitActual)
    {
        return new Profit.Builder()
                .profitId(profitId)
                .profitProjected(profitProjected)
                .profitActual(profitActual)
                .build();
    }
}
