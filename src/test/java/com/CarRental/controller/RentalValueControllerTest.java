package com.CarRental.controller;

import com.CarRental.domain.RentalValue;
import com.CarRental.factories.RentalValueFactory;
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
public class RentalValueControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/rentalValue";


    @Test
    public void testGetAllRentalValue() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetRentalValueById() {
        RentalValue rentalValue = restTemplate.getForObject(baseURL + "/rentalValue/1", RentalValue.class);
        System.out.println(rentalValue.getRentalValueId());
        assertNotNull(rentalValue);
    }

    @Test
    public void testCreateRentalValue() {
        RentalValue rentalValue = RentalValueFactory.buildRentalValue("902", "Bus", "4000");
        ResponseEntity<RentalValue> postResponse = restTemplate.postForEntity(baseURL + "/create", rentalValue, RentalValue.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateRentalValue() {
        int id = 1;
        RentalValue rentalValue = restTemplate.getForObject(baseURL + "/rentalValue/" + id, RentalValue.class);

        restTemplate.put(baseURL + "/rentalValue/" + id, rentalValue);
        RentalValue updatedRentalValue = restTemplate.getForObject(baseURL + "/RentalValue/" + id, RentalValue.class);
        assertNotNull(updatedRentalValue);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        RentalValue rentalValue = restTemplate.getForObject(baseURL + "/rentalValue/" + id, RentalValue.class);
        assertNotNull(rentalValue);
        restTemplate.delete(baseURL + "/rentalValue/" + id);
        try {
            rentalValue = restTemplate.getForObject(baseURL + "/rentalValue/" + id, RentalValue.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
