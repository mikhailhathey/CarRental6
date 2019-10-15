package com.CarRental.factories;

import com.CarRental.domain.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactFactoryTest {

    public void testBuildContact(){

    }

    private String ContactTest;

    @Before
    public void setUp() throws Exception {
        this.ContactTest = "ContactTest";
    }

    @Test
    public void buildCar() {
        Contact contact = ContactFactory.buildContact(123456, "13443975", "2345972398745", "Fiesta@ford.co.za");
        System.out.println(contact);
        Assert.assertNotNull(contact.getContactId());
    }
}