package com.CarRental.factories;

import com.CarRental.domain.Claims;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClaimsFactoryTest {

    public void testClaims(){

    }

    private String ClaimsTest;

    @Before
    public void setUp() throws Exception {
        this.ClaimsTest = "ClaimsTest";
    }

    @Test
    public void buildClaims() {
        Claims claims = ClaimsFactory.buildClaims(1234, "Discovery", "12000", "Stolen");
        System.out.println(claims);
        Assert.assertNotNull(claims.getClaimsId());
    }
}
