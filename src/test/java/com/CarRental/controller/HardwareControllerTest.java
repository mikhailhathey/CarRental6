package com.CarRental.controller;

import com.CarRental.domain.Hardware;
import com.CarRental.factories.HardwareFactory;
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
public class HardwareControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/hardware";


    @Test
    public void testGetAllHardware() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetHardwareById() {
        Hardware hardware = restTemplate.getForObject(baseURL + "/hardware/1", Hardware.class);
        System.out.println(hardware.getHardwareId());
        assertNotNull(hardware);
    }

    @Test
    public void testCreateHardware() {
        Hardware hardware = HardwareFactory.buildHardware(456, "Laptop", "4500");
        ResponseEntity<Hardware> postResponse = restTemplate.postForEntity(baseURL + "/create", hardware, Hardware.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateHardware() {
        int id = 1;
        Hardware hardware = restTemplate.getForObject(baseURL + "/hardware/" + id, Hardware.class);

        restTemplate.put(baseURL + "/hardware/" + id, hardware);
        Hardware updatedHardware = restTemplate.getForObject(baseURL + "/Hardware/" + id, Hardware.class);
        assertNotNull(updatedHardware);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Hardware hardware = restTemplate.getForObject(baseURL + "/hardware/" + id, Hardware.class);
        assertNotNull(hardware);
        restTemplate.delete(baseURL + "/hardware/" + id);
        try {
            hardware = restTemplate.getForObject(baseURL + "/hardware/" + id, Hardware.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
