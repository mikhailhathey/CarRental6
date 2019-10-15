package com.CarRental.factories;

import com.CarRental.domain.Infrastructure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InfrastructureFactoryTest {

    public void testBuildInfrastructure(){

    }

    private String InfrastructureTest;

    @Before
    public void setUp() throws Exception {
        this.InfrastructureTest = "InfrastructureTest";
    }

    @Test
    public void buildInfrastructure() {
        Infrastructure infrastructure = InfrastructureFactory.buildInfrastructure(789, "Dimension Data", "Network Servers", "50000");
        System.out.println(infrastructure);
        Assert.assertNotNull(infrastructure.getInfrastructureId());
    }
}