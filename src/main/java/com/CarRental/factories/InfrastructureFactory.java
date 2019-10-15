package com.CarRental.factories;

import com.CarRental.domain.Infrastructure;

public class InfrastructureFactory {

    public static Infrastructure buildInfrastructure(Integer infrastructureId, String infrastructureVendor, String infrastructureName, String infrastructureCost)
    {
        return new Infrastructure.Builder()
                .infrastructureId(infrastructureId)
                .infrastructureVendor(infrastructureVendor)
                .infrastructureName(infrastructureName)
                .infrastructureCost(infrastructureCost)
                .build();
    }
}
