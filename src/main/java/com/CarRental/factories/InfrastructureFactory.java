package com.CarRental.factories;

import com.CarRental.domain.Infrastructure;

public class InfrastructureFactory {

    public static Infrastructure buildInfrastructure(String infrastructureId, String infrastructureNumber, String infrastructureClass, String infrastructureDays, String infrastructureContact, String infrastructureBranch)
    {
        Infrastructure infrastructure = new Infrastructure.Builder()
                .infrastructureId(infrastructureId)
                .infrastructureNumber(infrastructureNumber)
                .infrastructureClass(infrastructureClass)
                .infrastructureDays(infrastructureDays)
                .infrastructureContact(infrastructureContact)
                .infrastructureBranch(infrastructureBranch)
                .build();
        return infrastructure;
    }
}