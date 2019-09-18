package com.CarRental.controller;

import com.CarRental.domain.Claims;
import com.CarRental.factories.ClaimsFactory;
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
public class ClaimsControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/claims";


    @Test
    public void testGetAllClaims() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetClaimsById() {
        Claims claims = restTemplate.getForObject(baseURL + "/claims/1", Claims.class);
        System.out.println(claims.getClaimsId());
        assertNotNull(claims);
    }

    @Test
    public void testCreateClaims() {
        Claims claims = ClaimsFactory.buildClaims("1234", "Discovery", "12000", "Stolen");
        ResponseEntity<Claims> postResponse = restTemplate.postForEntity(baseURL + "/create", claims, Claims.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateClaims() {
        int id = 1;
        Claims claims = restTemplate.getForObject(baseURL + "/claims/" + id, Claims.class);

        restTemplate.put(baseURL + "/claims/" + id, claims);
        Claims updatedClaims = restTemplate.getForObject(baseURL + "/Claims/" + id, Claims.class);
        assertNotNull(updatedClaims);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Claims claims = restTemplate.getForObject(baseURL + "/claims/" + id, Claims.class);
        assertNotNull(claims);
        restTemplate.delete(baseURL + "/claims/" + id);
        try {
            claims = restTemplate.getForObject(baseURL + "/claims/" + id, Claims.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
