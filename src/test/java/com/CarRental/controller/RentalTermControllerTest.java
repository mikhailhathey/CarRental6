package com.CarRental.controller;

import com.CarRental.domain.RentalTerm;
import com.CarRental.factories.RentalTermFactory;
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
public class RentalTermControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/rentalTerm";


    @Test
    public void testGetAllRentalTerm() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetRentalTermById() {
        RentalTerm rentalTerm = restTemplate.getForObject(baseURL + "/rentalTerm/1", RentalTerm.class);
        System.out.println(rentalTerm.getRentalTermId());
        assertNotNull(rentalTerm);
    }

    @Test
    public void testCreateRentalTerm() {
        RentalTerm rentalTerm = RentalTermFactory.buildRentalTerm("324", "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD");
        ResponseEntity<RentalTerm> postResponse = restTemplate.postForEntity(baseURL + "/create", rentalTerm, RentalTerm.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateRentalTerm() {
        int id = 1;
        RentalTerm rentalTerm = restTemplate.getForObject(baseURL + "/rentalTerm/" + id, RentalTerm.class);

        restTemplate.put(baseURL + "/rentalTerm/" + id, rentalTerm);
        RentalTerm updatedRentalTerm = restTemplate.getForObject(baseURL + "/RentalTerm/" + id, RentalTerm.class);
        assertNotNull(updatedRentalTerm);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        RentalTerm rentalTerm = restTemplate.getForObject(baseURL + "/rentalTerm/" + id, RentalTerm.class);
        assertNotNull(rentalTerm);
        restTemplate.delete(baseURL + "/rentalTerm/" + id);
        try {
            rentalTerm = restTemplate.getForObject(baseURL + "/rentalTerm/" + id, RentalTerm.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
