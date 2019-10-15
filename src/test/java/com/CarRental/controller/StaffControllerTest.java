package com.CarRental.controller;

import com.CarRental.domain.Staff;
import com.CarRental.factories.StaffFactory;
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
public class StaffControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";


    @Test
    public void testGetAllStaff() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetStaffById() {
        Staff address = restTemplate.getForObject(baseURL + "/address/1", Staff.class);
        System.out.println(address.getStaffId());
        assertNotNull(address);
    }

    @Test
    public void testCreateStaff() {
        Staff address = StaffFactory.buildStaff(345, "August", "April", "200000", "Claremont");
        ResponseEntity<Staff> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Staff.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateStaff() {
        int id = 1;
        Staff address = restTemplate.getForObject(baseURL + "/address/" + id, Staff.class);

        restTemplate.put(baseURL + "/address/" + id, address);
        Staff updatedStaff = restTemplate.getForObject(baseURL + "/Staff/" + id, Staff.class);
        assertNotNull(updatedStaff);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Staff address = restTemplate.getForObject(baseURL + "/address/" + id, Staff.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/address/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/address/" + id, Staff.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
