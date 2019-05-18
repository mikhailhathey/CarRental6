package com.CarRental.controller;

import com.CarRental.domain.Revenue;
import com.CarRental.factories.RevenueFactory;
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
public class RevenueControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/revenue";


    @Test
    public void testGetAllRevenue() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetRevenueById() {
        Revenue revenue = restTemplate.getForObject(baseURL + "/revenue/1", Revenue.class);
        System.out.println(revenue.getRevenueId());
        assertNotNull(revenue);
    }

    @Test
    public void testCreateRevenue() {
        Revenue revenue = RevenueFactory.buildRevenue("345", "August", "April", "200000", "Claremont");
        ResponseEntity<Revenue> postResponse = restTemplate.postForEntity(baseURL + "/create", revenue, Revenue.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateRevenue() {
        int id = 1;
        Revenue revenue = restTemplate.getForObject(baseURL + "/revenue/" + id, Revenue.class);

        restTemplate.put(baseURL + "/revenue/" + id, revenue);
        Revenue updatedRevenue = restTemplate.getForObject(baseURL + "/Revenue/" + id, Revenue.class);
        assertNotNull(updatedRevenue);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Revenue revenue = restTemplate.getForObject(baseURL + "/revenue/" + id, Revenue.class);
        assertNotNull(revenue);
        restTemplate.delete(baseURL + "/revenue/" + id);
        try {
            revenue = restTemplate.getForObject(baseURL + "/revenue/" + id, Revenue.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
