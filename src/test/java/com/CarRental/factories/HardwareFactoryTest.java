package com.CarRental.factories;

import com.CarRental.domain.Hardware;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HardwareFactoryTest {

    public void testBuildHardware(){

    }

    private String HardwareTest;

    @Before
    public void setUp() throws Exception {
        this.HardwareTest = "HardwareTest";
    }

    @Test
    public void buildHardware() {
        Hardware hardware = HardwareFactory.buildHardware("456", "Laptop", "4500");
        System.out.println(hardware);
        Assert.assertNotNull(hardware.getHardwareId());
    }
}
