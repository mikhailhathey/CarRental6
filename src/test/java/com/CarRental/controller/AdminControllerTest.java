package com.CarRental.controller;

import com.CarRental.domain.Admin;
import com.CarRental.factories.AdminFactory;
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
public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/admin";


    @Test
    public void testGetAllAdmin() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAdminById() {
        Admin admin = restTemplate.getForObject(baseURL + "/admin/1", Admin.class);
        System.out.println(admin.getAdminId());
        assertNotNull(admin);
    }

    @Test
    public void testCreateAdmin() {
        Admin admin = AdminFactory.buildAdmin(123, "AdminUser", "Password123");
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(baseURL + "/create", admin, Admin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateAdmin() {
        int id = 1;
        Admin admin = restTemplate.getForObject(baseURL + "/admin/" + id, Admin.class);

        restTemplate.put(baseURL + "/admin/" + id, admin);
        Admin updatedAdmin = restTemplate.getForObject(baseURL + "/Admin/" + id, Admin.class);
        assertNotNull(updatedAdmin);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Admin admin = restTemplate.getForObject(baseURL + "/admin/" + id, Admin.class);
        assertNotNull(admin);
        restTemplate.delete(baseURL + "/admin/" + id);
        try {
            admin = restTemplate.getForObject(baseURL + "/admin/" + id, Admin.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
