package com.CarRental.controller;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
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
public class AddressControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";


    @Test
    public void testGetAllAddress() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetAddressById() {
        Address address = restTemplate.getForObject(baseURL + "/address/1", Address.class);
        System.out.println(address.getAddressId());
        assertNotNull(address);
    }

    @Ignore
    public void testCreateAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAddress() {
        int id = 1;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);

        restTemplate.put(baseURL + "/address/" + id, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/Address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/address/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}