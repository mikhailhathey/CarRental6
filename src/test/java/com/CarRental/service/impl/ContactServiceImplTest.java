package com.CarRental.service.impl;

import com.CarRental.domain.Contact;
import com.CarRental.factories.ContactFactory;
import com.CarRental.service.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceImplTest {
  @Autowired
  @Qualifier("ContactServiceImpl")
  private ContactService contactService;
  private Contact contact;
  private Set<Contact> contacts = new HashSet<>();

  @Before
  public void setUp() {
      contact = contactService.create(ContactFactory.buildContact("123456", "13443975", "2345972398745", "Fiesta@ford.co.za"));
      contacts.add(contact);
  }

  @Test
  public void create() {
      Contact createContact = contactService.create(ContactFactory.buildContact(
              "123456", "13443975", "2345972398745", "Fiesta@ford.co.za"));
      contacts.add(createContact);
      Assert.assertEquals(createContact, contactService.read(createContact.getContactId()));
  }

  @Test
  public void read() {
      Contact readTestContact = contactService.create(ContactFactory.buildContact(
              "123456", "13443975", "2345972398745", "Fiesta@ford.co.za"));
      Assert.assertEquals(readTestContact, contactService.read(readTestContact.getContactId()));
  }

  @Test
  public void update() {
      String newContactEmail = "Test";
      Contact updateContact = contactService.update(new Contact.Builder().copy(contact).contactEmail(newContactEmail).build());
      contacts.add(updateContact);
      Assert.assertEquals(updateContact, contactService.read(updateContact.getContactId()));
  }

  @Test
  public void delete() {
      contacts.addAll(contactService.getAll());
      Contact deleteContact = contactService.create(ContactFactory.buildContact("123456", "13443975", "2345972398745", "Fiesta@ford.co.za"));
      contacts.add(deleteContact);
      contacts.remove(deleteContact);
      contactService.delete(deleteContact.getContactId());
      Assert.assertEquals(contacts.size(), contactService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Contact> contactSet = contactService.getAll();
      Assert.assertEquals(contactSet.size(), contactService.getAll().size());
  }
}
//"123456", "13443975", "2345972398745", "Fiesta@ford.co.za"
