package com.CarRental.controller;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.factories.VehicleSellingPriceFactory;
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
public class VehicleSellingPriceControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/vehicleSellingPrice";


    @Test
    public void testGetAllVehicleSellingPrice() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetVehicleSellingPriceById() {
        VehicleSellingPrice vehicleSellingPrice = restTemplate.getForObject(baseURL + "/vehicleSellingPrice/1", VehicleSellingPrice.class);
        System.out.println(vehicleSellingPrice.getVehicleSellingPriceId());
        assertNotNull(vehicleSellingPrice);
    }

    @Test
    public void testCreateVehicleSellingPrice() {
        VehicleSellingPrice vehicleSellingPrice = VehicleSellingPriceFactory.buildVehicleSellingPrice("452", "2016", "180000");
        ResponseEntity<VehicleSellingPrice> postResponse = restTemplate.postForEntity(baseURL + "/create", vehicleSellingPrice, VehicleSellingPrice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateVehicleSellingPrice() {
        int id = 1;
        VehicleSellingPrice vehicleSellingPrice = restTemplate.getForObject(baseURL + "/vehicleSellingPrice/" + id, VehicleSellingPrice.class);

        restTemplate.put(baseURL + "/vehicleSellingPrice/" + id, vehicleSellingPrice);
        VehicleSellingPrice updatedVehicleSellingPrice = restTemplate.getForObject(baseURL + "/VehicleSellingPrice/" + id, VehicleSellingPrice.class);
        assertNotNull(updatedVehicleSellingPrice);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        VehicleSellingPrice vehicleSellingPrice = restTemplate.getForObject(baseURL + "/vehicleSellingPrice/" + id, VehicleSellingPrice.class);
        assertNotNull(vehicleSellingPrice);
        restTemplate.delete(baseURL + "/vehicleSellingPrice/" + id);
        try {
            vehicleSellingPrice = restTemplate.getForObject(baseURL + "/vehicleSellingPrice/" + id, VehicleSellingPrice.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
