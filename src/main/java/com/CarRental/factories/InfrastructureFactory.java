package com.CarRental.factories;

import com.CarRental.domain.Infrastructure;

public class InfrastructureFactory {

    public static Infrastructure buildInfrastructure(String infrastructureId, String infrastructureVendor, String infrastructureName, String infrastructureCost)
    {
        Infrastructure infrastructure = new Infrastructure.Builder()
                .infrastructureId(infrastructureId)
                .infrastructureVendor(infrastructureVendor)
                .infrastructureName(infrastructureName)
                .infrastructureCost(infrastructureCost)
                .build();
        return infrastructure;
    }
}