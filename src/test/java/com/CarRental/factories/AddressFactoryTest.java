package com.CarRental.factories;

import com.CarRental.domain.Contact;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class AddressFactoryTest extends TestCase {

    @Test
    public void testBuildAddress() {

        Address a = AddressFactory.buildAddress("81", "123", "Testing", "Lansdowne", "7764", "Cape Town");
        System.out.println(c);
        Assert.assertNotNull(c.getCell());
    }

}