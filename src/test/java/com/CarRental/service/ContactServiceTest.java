package com.CarRental.service;

import com.CarRental.domain.Contact;
import com.CarRental.factories.ContactFactory;
import com.CarRental.repositories.impl.ContactRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class ContactServiceTest {

    private ContactRepositoryImpl repository;
    private Contact contact;


    @Before
    public void setUp() throws Exception {
        this.repository = ContactRepositoryImpl.getRepository();
        this.contact = ContactFactory.buildContact("123456", "13443975", "2345972398745", "Fiesta@ford.co.za");
    }

    @Test
    public void getAll() {
        Set<Contact> contact = this.repository.getAll();
        System.out.println("In getall, all = " + contact);
    }

}
