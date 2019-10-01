package com.CarRental.controller;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AddressControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String BASE_URL = "http://localhost:8080/address";


    @Before
    public void setUp() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create", address, Address.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void createAdminAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create", address, Address.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
        System.out.println("Successfully validated user authenticated");

    }

    @Test
    public void createUserAddress() {
        Address address = AddressFactory.buildAddress("456", "20", "Side Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.withBasicAuth("user", "password")
                .postForEntity(BASE_URL + "/create", address, Address.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
        System.out.println("Successfully validated user authenticated");
    }

    @Test
    public void updateAddress() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "456");
        Address address = AddressFactory.buildAddress("789", "45", "Left Road", "Crawford", "7780", "Cape Town");
        restTemplate.put(BASE_URL + "/update/", parameters, address);
    }

    @Test
    public void readAddress() {
        Address address = restTemplate.getForObject(BASE_URL + "/read/123",
                Address.class);
        Assert.assertNotNull(address);
    }


    @Test
    public void delete() {
        Address address = AddressFactory.buildAddress("456", "20", "Side Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create", address, Address.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "456");
        restTemplate.delete(BASE_URL + "/delete/" + parameters, Address.class);
        try {
            Address deleteAddress = restTemplate.getForObject(BASE_URL + "/read/456", Address.class);
            System.out.println(deleteAddress);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> stringHttpEntity = new HttpEntity<>(null, httpHeaders);
        HttpEntity<String> response = restTemplate.exchange(
                BASE_URL + "/getAll/all", HttpMethod.GET,
                stringHttpEntity, String.class);
        Assert.assertNotNull(response.getBody());
    }

    /*@Test
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
    }*/

    /*@Test
    public void testCreateAddress() {
        Address address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(BASE_URL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }*/

}