package com.CarRental.repositories.impl;

import com.CarRental.domain.Contact;
import com.CarRental.factories.ContactFactory;
import com.CarRental.repositories.ContactRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {

    private ContactRepository repository;
    private Contact contact;

    private Contact getSavedContact() {
        Set<Contact> savedContacts = this.repository.getAll();
        return savedContacts.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ContactRepositoryImpl.getRepository();
        this.contact = ContactFactory.buildContact("123456", "13443975", "2345972398745", "Fiesta@ford.co.za");
    }

    @Test
    public void a_create() {
        Contact created = this.repository.create(this.contact);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.contact);
    }

    @Test
    public void b_read() {
       Contact savedContact = getSavedContact();
        System.out.println("In read, contactId = "+ savedContact.getContactId());
        Contact read = this.repository.read(savedContact.getContactId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedContact, read);
    }

    @Test
    public void e_delete() {
        Contact savedContact = getSavedContact();
        this.repository.delete(savedContact.getContactId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Contact Name";
        Contact contact = new Contact.Builder().copy(getSavedContact()).contactEmail(newname).build();
        System.out.println("In update, about_to_updated = " + contact);
        Contact updated = this.repository.update(contact);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getContactEmail());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Contact> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
