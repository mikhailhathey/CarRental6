package com.CarRental.controller;

import com.CarRental.domain.Contact;
import com.CarRental.factories.ContactFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContactControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/contact";


    @Test
    public void testGetAllContact() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetContactById() {
        Contact contact = restTemplate.getForObject(baseURL + "/contact/1", Contact.class);
        System.out.println(contact.getContactId());
        assertNotNull(contact);
    }

    @Test
    public void testCreateContact() {
        Contact contact = ContactFactory.buildContact("123456", "13443975", "2345972398745", "Fiesta@ford.co.za");
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(baseURL + "/create", contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateContact() {
        int id = 1;
        Contact contact = restTemplate.getForObject(baseURL + "/contact/" + id, Contact.class);

        restTemplate.put(baseURL + "/contact/" + id, contact);
        Contact updatedContact = restTemplate.getForObject(baseURL + "/Contact/" + id, Contact.class);
        assertNotNull(updatedContact);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Contact contact = restTemplate.getForObject(baseURL + "/contact/" + id, Contact.class);
        assertNotNull(contact);
        restTemplate.delete(baseURL + "/contact/" + id);
        try {
            contact = restTemplate.getForObject(baseURL + "/contact/" + id, Contact.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
