package com.CarRental.factories;

import com.CarRental.domain.Contact;
import junit.framework.Assert;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void testBuildContact() {

            Contact c = ContactFactory.buildContact("123","0124567897", "0213164677", "test@test.com");
            System.out.println(c);
        Assert.assertNotNull(c.getCell());
    }
}
