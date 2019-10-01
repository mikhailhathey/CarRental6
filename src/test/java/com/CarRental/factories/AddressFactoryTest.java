package com.CarRental.factories;

import com.CarRental.domain.Address;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest extends TestCase {

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        Assert.assertEquals("Main Road", address.getStreetName());
    }
}