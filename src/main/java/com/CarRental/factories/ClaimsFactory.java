package com.CarRental.factories;

import com.CarRental.domain.Claims;

public class ClaimsFactory {

    public static Claims buildClaims(String claimsId, String claimProvider, String claimValue, String claimReason)
    {
        Claims claims = new Claims.Builder()
                .claimsId(claimsId)
                .claimProvider(claimProvider)
                .claimValue(claimValue)
                .claimReason(claimReason)
                .build();
        return claims;
    }
}