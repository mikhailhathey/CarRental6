package com.CarRental.controller;

import com.CarRental.domain.FleetManager;
import com.CarRental.factories.FleetManagerFactory;
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
public class FleetManagerControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/fleetManager";


    @Test
    public void testGetAllFleetManager() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetFleetManagerById() {
        FleetManager fleetManager = restTemplate.getForObject(baseURL + "/fleetManager/1", FleetManager.class);
        System.out.println(fleetManager.getFleetManagerId());
        assertNotNull(fleetManager);
    }

    @Test
    public void testCreateFleetManager() {
        FleetManager fleetManager = FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth");
        ResponseEntity<FleetManager> postResponse = restTemplate.postForEntity(baseURL + "/create", fleetManager, FleetManager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateFleetManager() {
        int id = 1;
        FleetManager fleetManager = restTemplate.getForObject(baseURL + "/fleetManager/" + id, FleetManager.class);

        restTemplate.put(baseURL + "/fleetManager/" + id, fleetManager);
        FleetManager updatedFleetManager = restTemplate.getForObject(baseURL + "/FleetManager/" + id, FleetManager.class);
        assertNotNull(updatedFleetManager);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        FleetManager fleetManager = restTemplate.getForObject(baseURL + "/fleetManager/" + id, FleetManager.class);
        assertNotNull(fleetManager);
        restTemplate.delete(baseURL + "/fleetManager/" + id);
        try {
            fleetManager = restTemplate.getForObject(baseURL + "/fleetManager/" + id, FleetManager.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
