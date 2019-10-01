package com.CarRental.controller;

import com.CarRental.domain.StaffType;
import com.CarRental.factories.StaffTypeFactory;
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
public class StaffTypeControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/staffType";


    @Test
    public void testGetAllStaffType() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetStaffTypeById() {
        StaffType staffType = restTemplate.getForObject(baseURL + "/staffType/1", StaffType.class);
        System.out.println(staffType.getStaffTypeId());
        assertNotNull(staffType);
    }

    @Test
    public void testCreateStaffType() {
        StaffType staffType = StaffTypeFactory.buildStaffType("765", "Customer Care", "200000");
        ResponseEntity<StaffType> postResponse = restTemplate.postForEntity(baseURL + "/create", staffType, StaffType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateStaffType() {
        int id = 1;
        StaffType staffType = restTemplate.getForObject(baseURL + "/staffType/" + id, StaffType.class);

        restTemplate.put(baseURL + "/staffType/" + id, staffType);
        StaffType updatedStaffType = restTemplate.getForObject(baseURL + "/StaffType/" + id, StaffType.class);
        assertNotNull(updatedStaffType);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        StaffType staffType = restTemplate.getForObject(baseURL + "/staffType/" + id, StaffType.class);
        assertNotNull(staffType);
        restTemplate.delete(baseURL + "/staffType/" + id);
        try {
            staffType = restTemplate.getForObject(baseURL + "/staffType/" + id, StaffType.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
