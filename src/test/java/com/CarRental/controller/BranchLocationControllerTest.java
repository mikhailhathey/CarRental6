package com.CarRental.controller;

import com.CarRental.domain.BranchLocation;
import com.CarRental.factories.BranchLocationFactory;
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
public class BranchLocationControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/branchLocation";


    @Test
    public void testGetAllBranchLocation() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetBranchLocationById() {
        BranchLocation branchLocation = restTemplate.getForObject(baseURL + "/branchLocation/1", BranchLocation.class);
        System.out.println(branchLocation.getBranchLocationId());
        assertNotNull(branchLocation);
    }

    @Ignore
    public void testCreateBranchLocation() {
        BranchLocation branchLocation = BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager");
        ResponseEntity<BranchLocation> postResponse = restTemplate.postForEntity(baseURL + "/create", branchLocation, BranchLocation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateBranchLocation() {
        int id = 1;
        BranchLocation branchLocation = restTemplate.getForObject(baseURL + "/branchLocation/" + id, BranchLocation.class);

        restTemplate.put(baseURL + "/branchLocation/" + id, branchLocation);
        BranchLocation updatedBranchLocation = restTemplate.getForObject(baseURL + "/BranchLocation/" + id, BranchLocation.class);
        assertNotNull(updatedBranchLocation);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        BranchLocation branchLocation = restTemplate.getForObject(baseURL + "/branchLocation/" + id, BranchLocation.class);
        assertNotNull(branchLocation);
        restTemplate.delete(baseURL + "/branchLocation/" + id);
        try {
            branchLocation = restTemplate.getForObject(baseURL + "/branchLocation/" + id, BranchLocation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
