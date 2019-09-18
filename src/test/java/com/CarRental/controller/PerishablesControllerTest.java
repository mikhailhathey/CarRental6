package com.CarRental.controller;

import com.CarRental.domain.Perishables;
import com.CarRental.factories.PerishablesFactory;
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
public class PerishablesControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/perishables";


    @Test
    public void testGetAllPerishables() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPerishablesById() {
        Perishables perishables = restTemplate.getForObject(baseURL + "/perishables/1", Perishables.class);
        System.out.println(perishables.getPerishablesId());
        assertNotNull(perishables);
    }

    @Test
    public void testCreatePerishables() {
        Perishables perishables = PerishablesFactory.buildPerishables("567", "Bread", "12/05/2019", "5");
        ResponseEntity<Perishables> postResponse = restTemplate.postForEntity(baseURL + "/create", perishables, Perishables.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePerishables() {
        int id = 1;
        Perishables perishables = restTemplate.getForObject(baseURL + "/perishables/" + id, Perishables.class);

        restTemplate.put(baseURL + "/perishables/" + id, perishables);
        Perishables updatedPerishables = restTemplate.getForObject(baseURL + "/Perishables/" + id, Perishables.class);
        assertNotNull(updatedPerishables);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Perishables perishables = restTemplate.getForObject(baseURL + "/perishables/" + id, Perishables.class);
        assertNotNull(perishables);
        restTemplate.delete(baseURL + "/perishables/" + id);
        try {
            perishables = restTemplate.getForObject(baseURL + "/perishables/" + id, Perishables.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
