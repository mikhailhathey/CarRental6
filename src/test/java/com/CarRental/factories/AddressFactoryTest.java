package com.CarRental.factories;

import com.CarRental.domain.Address;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressFactoryTest extends TestCase {

    public void testBuildAddress() {
    }

    private String AddressTest;

    @Before
    public void setUp() throws Exception {
        this.AddressTest = "AddressTest";
    }

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        System.out.println(address);
        Assert.assertNotNull(address.getAddressId());
    }
}