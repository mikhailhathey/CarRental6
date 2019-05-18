package com.CarRental.controller;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.factories.ChannelPartnerFactory;
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
public class ChannelPartnerControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/channelPartner";


    @Test
    public void testGetAllChannelPartner() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetChannelPartnerById() {
        ChannelPartner channelPartner = restTemplate.getForObject(baseURL + "/channelPartner/1", ChannelPartner.class);
        System.out.println(channelPartner.getChannelPartnerId());
        assertNotNull(channelPartner);
    }

    @Test
    public void testCreateChannelPartner() {
        ChannelPartner channelPartner = ChannelPartnerFactory.buildChannelPartner("1234", "Microsoft", "John", "john@microsoft.com");
        ResponseEntity<ChannelPartner> postResponse = restTemplate.postForEntity(baseURL + "/create", channelPartner, ChannelPartner.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateChannelPartner() {
        int id = 1;
        ChannelPartner channelPartner = restTemplate.getForObject(baseURL + "/channelPartner/" + id, ChannelPartner.class);

        restTemplate.put(baseURL + "/channelPartner/" + id, channelPartner);
        ChannelPartner updatedChannelPartner = restTemplate.getForObject(baseURL + "/ChannelPartner/" + id, ChannelPartner.class);
        assertNotNull(updatedChannelPartner);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        ChannelPartner channelPartner = restTemplate.getForObject(baseURL + "/channelPartner/" + id, ChannelPartner.class);
        assertNotNull(channelPartner);
        restTemplate.delete(baseURL + "/channelPartner/" + id);
        try {
            channelPartner = restTemplate.getForObject(baseURL + "/channelPartner/" + id, ChannelPartner.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
