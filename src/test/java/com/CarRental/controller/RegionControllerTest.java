package com.CarRental.controller;

import com.CarRental.domain.Region;
import com.CarRental.factories.RegionFactory;
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
public class RegionControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/region";


    @Test
    public void testGetAllRegion() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetRegionById() {
        Region region = restTemplate.getForObject(baseURL + "/region/1", Region.class);
        System.out.println(region.getRegionId());
        assertNotNull(region);
    }

    @Test
    public void testCreateRegion() {
        Region region = RegionFactory.buildRegion("765", "Hatfield", "Pretoria");
        ResponseEntity<Region> postResponse = restTemplate.postForEntity(baseURL + "/create", region, Region.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateRegion() {
        int id = 1;
        Region region = restTemplate.getForObject(baseURL + "/region/" + id, Region.class);

        restTemplate.put(baseURL + "/region/" + id, region);
        Region updatedRegion = restTemplate.getForObject(baseURL + "/Region/" + id, Region.class);
        assertNotNull(updatedRegion);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Region region = restTemplate.getForObject(baseURL + "/region/" + id, Region.class);
        assertNotNull(region);
        restTemplate.delete(baseURL + "/region/" + id);
        try {
            region = restTemplate.getForObject(baseURL + "/region/" + id, Region.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
