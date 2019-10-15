package com.CarRental.factories;

import com.CarRental.domain.Claims;

public class ClaimsFactory {

    public static Claims buildClaims(Integer claimsId, String claimProvider, String claimValue, String claimReason)
    {
        return new Claims.Builder()
                .claimsId(claimsId)
                .claimProvider(claimProvider)
                .claimValue(claimValue)
                .claimReason(claimReason)
                .build();
    }
}
