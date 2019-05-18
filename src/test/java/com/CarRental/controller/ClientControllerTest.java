package com.CarRental.controller;

import com.CarRental.domain.Client;
import com.CarRental.factories.ClientFactory;
import org.junit.Ignore;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class ClientControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/client";


    @Test
    public void testGetAllClient() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetClientById() {
        Client client = restTemplate.getForObject(baseURL + "/client/1", Client.class);
        System.out.println(client.getClientId());
        assertNotNull(client);
    }

    @Ignore
    public void testCreateClient() {
        Client client = ClientFactory.buildClient("1234", "082123456789", "Clientele", "test@clientele.com", "clientele.co.za", "1 Street Road");
        ResponseEntity<Client> postResponse = restTemplate.postForEntity(baseURL + "/create", client, Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateClient() {
        int id = 1;
        Client client = restTemplate.getForObject(baseURL + "/client/" + id, Client.class);

        restTemplate.put(baseURL + "/client/" + id, client);
        Client updatedClient = restTemplate.getForObject(baseURL + "/Client/" + id, Client.class);
        assertNotNull(updatedClient);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Client client = restTemplate.getForObject(baseURL + "/client/" + id, Client.class);
        assertNotNull(client);
        restTemplate.delete(baseURL + "/client/" + id);
        try {
            client = restTemplate.getForObject(baseURL + "/client/" + id, Client.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
