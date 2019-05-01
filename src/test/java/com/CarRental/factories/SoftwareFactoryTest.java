package com.CarRental.factories;

import com.CarRental.domain.Software;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoftwareFactoryTest {

    public void testBuildSoftware(){

    }

    private String SoftwareTest;

    @Before
    public void setUp() throws Exception {
        this.SoftwareTest = "SoftwareTest";
    }

    @Test
    public void buildSoftware() {
        Software software = SoftwareFactory.buildSoftware("769", "Pascal", "2.6", "3000");
        System.out.println(software);
        Assert.assertNotNull(software.getSoftwareId());
    }
}
