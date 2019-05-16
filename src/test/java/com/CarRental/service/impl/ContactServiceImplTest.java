package com.CarRental.service.impl;

import com.CarRental.domain.Contact;
import com.CarRental.factories.ContactFactory;
import com.CarRental.repositories.impl.ContactRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {

    private ContactRepositoryImpl repository;
    private Contact contact;

    private Contact getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.contact);
    }

    @Test
    public void c_update() {
        String newContactName = "Application Development Theory 3";
        Contact updated = new Contact.Builder().copy(getSaved()).contactId(newContactName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newContactName, updated.getContactId());
    }

    @Test
    public void e_delete() {
        Contact saved = getSaved();
        this.repository.delete(saved.getContactId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Contact saved = getSaved();
        Contact read = this.repository.read(saved.getContactId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Contact> contacts = this.repository.getAll();
        System.out.println("In getall, all = " + contacts);
    }
}
