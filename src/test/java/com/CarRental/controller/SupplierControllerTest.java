package com.CarRental.controller;

import com.CarRental.domain.Supplier;
import com.CarRental.factories.SupplierFactory;
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
public class SupplierControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/supplier";


    @Test
    public void testGetAllSupplier() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/1", Supplier.class);
        System.out.println(supplier.getSupplierId());
        assertNotNull(supplier);
    }

    @Test
    public void testCreateSupplier() {
        Supplier supplier = SupplierFactory.buildSupplier("453", "Makro", "Johan", "johan@makro.com");
        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(baseURL + "/create", supplier, Supplier.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateSupplier() {
        int id = 1;
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/" + id, Supplier.class);

        restTemplate.put(baseURL + "/supplier/" + id, supplier);
        Supplier updatedSupplier = restTemplate.getForObject(baseURL + "/Supplier/" + id, Supplier.class);
        assertNotNull(updatedSupplier);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/" + id, Supplier.class);
        assertNotNull(supplier);
        restTemplate.delete(baseURL + "/supplier/" + id);
        try {
            supplier = restTemplate.getForObject(baseURL + "/supplier/" + id, Supplier.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
