package com.CarRental.controller;

import com.CarRental.domain.Software;
import com.CarRental.factories.SoftwareFactory;
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
public class SoftwareControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/software";


    @Test
    public void testGetAllSoftware() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetSoftwareById() {
        Software software = restTemplate.getForObject(baseURL + "/software/1", Software.class);
        System.out.println(software.getSoftwareId());
        assertNotNull(software);
    }

    @Test
    public void testCreateSoftware() {
        Software software = SoftwareFactory.buildSoftware("769", "Pascal", "2.6", "3000");
        ResponseEntity<Software> postResponse = restTemplate.postForEntity(baseURL + "/create", software, Software.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateSoftware() {
        int id = 1;
        Software software = restTemplate.getForObject(baseURL + "/software/" + id, Software.class);

        restTemplate.put(baseURL + "/software/" + id, software);
        Software updatedSoftware = restTemplate.getForObject(baseURL + "/Software/" + id, Software.class);
        assertNotNull(updatedSoftware);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Software software = restTemplate.getForObject(baseURL + "/software/" + id, Software.class);
        assertNotNull(software);
        restTemplate.delete(baseURL + "/software/" + id);
        try {
            software = restTemplate.getForObject(baseURL + "/software/" + id, Software.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
