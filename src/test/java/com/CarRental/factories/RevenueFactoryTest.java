package com.CarRental.factories;

import com.CarRental.domain.Revenue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RevenueFactoryTest {

    public void testBuildRevenue(){

    }

    private String RevenueTest;

    @Before
    public void setUp() throws Exception {
        this.RevenueTest = "RevenueTest";
    }

    @Test
    public void buildRevenue() {
        Revenue revenue = RevenueFactory.buildRevenue("345", "August", "April", "200000", "Claremont");
        System.out.println(revenue);
        Assert.assertNotNull(revenue.getRevenueId());
    }
}