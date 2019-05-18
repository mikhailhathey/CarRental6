package com.CarRental.controller;

import com.CarRental.domain.Profit;
import com.CarRental.factories.ProfitFactory;
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
public class ProfitControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/profit";


    @Test
    public void testGetAllProfit() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetProfitById() {
        Profit profit = restTemplate.getForObject(baseURL + "/profit/1", Profit.class);
        System.out.println(profit.getProfitId());
        assertNotNull(profit);
    }

    @Ignore
    public void testCreateProfit() {
        Profit profit = ProfitFactory.buildProfit("789", "100000", "120000");
        ResponseEntity<Profit> postResponse = restTemplate.postForEntity(baseURL + "/create", profit, Profit.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateProfit() {
        int id = 1;
        Profit profit = restTemplate.getForObject(baseURL + "/profit/" + id, Profit.class);

        restTemplate.put(baseURL + "/profit/" + id, profit);
        Profit updatedProfit = restTemplate.getForObject(baseURL + "/Profit/" + id, Profit.class);
        assertNotNull(updatedProfit);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Profit profit = restTemplate.getForObject(baseURL + "/profit/" + id, Profit.class);
        assertNotNull(profit);
        restTemplate.delete(baseURL + "/profit/" + id);
        try {
            profit = restTemplate.getForObject(baseURL + "/profit/" + id, Profit.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
