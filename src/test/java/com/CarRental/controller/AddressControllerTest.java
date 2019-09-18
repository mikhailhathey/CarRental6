package com.CarRental.controller;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class AddressControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/address/lookup/address";

    @Test
    public void testGetAllAddress() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAddressById() {
        Address address = restTemplate.getForObject(BASE_URL + "/address/1", Address.class);
        System.out.println(address.getAddressId());
        assertNotNull(address);
    }

    /*@Test
    public void testCreateAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(BASE_URL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }*/

    @Test
    public void createAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/newAddress", address, Address.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result);
        assertNotNull(result.getBody());
        System.out.println("Successfully validated user authenticated");
    }

    @Test
    public void createUserAddress() {
        ResponseEntity<Address> result = null;
        try{
            Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
             result = restTemplate.withBasicAuth("user", "admin")
                    .postForEntity(BASE_URL + "/create/newAddress", address, Address.class);

        }catch (Exception e){
            System.out.println("Error from server : " + e.getMessage());

            assertNull("Successfully validated user not authenticated",result);
        }
        assertNull("Failed to validate user is not authenticated",result);
    }

    @Test
    public void testUpdateAddress() {
        int id = 1;
        Address address = restTemplate.getForObject(BASE_URL + "/address/" + id, Address.class);

        restTemplate.put(BASE_URL + "/address/" + id, address);
        Address updatedAddress = restTemplate.getForObject(BASE_URL + "/Address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Address address = restTemplate.getForObject(BASE_URL + "/address/" + id, Address.class);
        assertNotNull(address);
        restTemplate.delete(BASE_URL + "/address/" + id);
        try {
            address = restTemplate.getForObject(BASE_URL + "/address/" + id, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }


    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}