package com.CarRental.factories;

import com.CarRental.domain.FleetManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FleetManagerFactoryTest {

    public void testBuildFleetManager(){

    }

    private String FleetManagerTest;

    @Before
    public void setUp() throws Exception {
        this.FleetManagerTest = "FleetManagerTest";
    }

    @Test
    public void buildExpenses() {
        FleetManager fleetManager = FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth");
        System.out.println(fleetManager);
        Assert.assertNotNull(fleetManager.getFleetManagerId());
    }
}