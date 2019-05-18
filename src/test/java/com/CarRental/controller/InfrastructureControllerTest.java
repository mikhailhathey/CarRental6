package com.CarRental.controller;

import com.CarRental.domain.Infrastructure;
import com.CarRental.factories.InfrastructureFactory;
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
public class InfrastructureControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/infrastructure";


    @Test
    public void testGetAllInfrastructure() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetInfrastructureById() {
        Infrastructure infrastructure = restTemplate.getForObject(baseURL + "/infrastructure/1", Infrastructure.class);
        System.out.println(infrastructure.getInfrastructureId());
        assertNotNull(infrastructure);
    }

    @Ignore
    public void testCreateInfrastructure() {
        Infrastructure infrastructure = InfrastructureFactory.buildInfrastructure("789", "Dimension Data", "Network Servers", "50000");
        ResponseEntity<Infrastructure> postResponse = restTemplate.postForEntity(baseURL + "/create", infrastructure, Infrastructure.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateInfrastructure() {
        int id = 1;
        Infrastructure infrastructure = restTemplate.getForObject(baseURL + "/infrastructure/" + id, Infrastructure.class);

        restTemplate.put(baseURL + "/infrastructure/" + id, infrastructure);
        Infrastructure updatedInfrastructure = restTemplate.getForObject(baseURL + "/Infrastructure/" + id, Infrastructure.class);
        assertNotNull(updatedInfrastructure);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Infrastructure infrastructure = restTemplate.getForObject(baseURL + "/infrastructure/" + id, Infrastructure.class);
        assertNotNull(infrastructure);
        restTemplate.delete(baseURL + "/infrastructure/" + id);
        try {
            infrastructure = restTemplate.getForObject(baseURL + "/infrastructure/" + id, Infrastructure.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
