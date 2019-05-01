package com.CarRental.factories;

import com.CarRental.domain.BranchLocation;

public class BranchLocationFactory {

    public static BranchLocation buildBranchLocation(String branchLocationId, String branchName, String branchManager)
    {
        BranchLocation branchLocation = new BranchLocation.Builder()
                .branchLocationId(branchLocationId)
                .branchName(branchName)
                .branchManager(branchManager)
                .build();
        return branchLocation;
    }
}