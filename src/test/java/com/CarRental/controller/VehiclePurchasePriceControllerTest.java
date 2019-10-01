package com.CarRental.controller;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.factories.VehiclePurchasePriceFactory;
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
public class VehiclePurchasePriceControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/vehiclePurchasePrice";


    @Test
    public void testGetAllVehiclePurchasePrice() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetVehiclePurchasePriceById() {
        VehiclePurchasePrice vehiclePurchasePrice = restTemplate.getForObject(baseURL + "/vehiclePurchasePrice/1", VehiclePurchasePrice.class);
        System.out.println(vehiclePurchasePrice.getVehiclePurchasePriceId());
        assertNotNull(vehiclePurchasePrice);
    }

    @Test
    public void testCreateVehiclePurchasePrice() {
        VehiclePurchasePrice vehiclePurchasePrice = VehiclePurchasePriceFactory.buildVehiclePurchasePrice("452", "2016", "160000");
        ResponseEntity<VehiclePurchasePrice> postResponse = restTemplate.postForEntity(baseURL + "/create", vehiclePurchasePrice, VehiclePurchasePrice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateVehiclePurchasePrice() {
        int id = 1;
        VehiclePurchasePrice vehiclePurchasePrice = restTemplate.getForObject(baseURL + "/vehiclePurchasePrice/" + id, VehiclePurchasePrice.class);

        restTemplate.put(baseURL + "/vehiclePurchasePrice/" + id, vehiclePurchasePrice);
        VehiclePurchasePrice updatedVehiclePurchasePrice = restTemplate.getForObject(baseURL + "/VehiclePurchasePrice/" + id, VehiclePurchasePrice.class);
        assertNotNull(updatedVehiclePurchasePrice);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        VehiclePurchasePrice vehiclePurchasePrice = restTemplate.getForObject(baseURL + "/vehiclePurchasePrice/" + id, VehiclePurchasePrice.class);
        assertNotNull(vehiclePurchasePrice);
        restTemplate.delete(baseURL + "/vehiclePurchasePrice/" + id);
        try {
            vehiclePurchasePrice = restTemplate.getForObject(baseURL + "/vehiclePurchasePrice/" + id, VehiclePurchasePrice.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
