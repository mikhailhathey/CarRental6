package com.CarRental.controller;

import com.CarRental.domain.Car;
import com.CarRental.factories.CarFactory;
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
public class CarControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/car";


    @Test
    public void testGetAllCar() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCarById() {
        Car car = restTemplate.getForObject(baseURL + "/car/1", Car.class);
        System.out.println(car.getCarId());
        assertNotNull(car);
    }

    @Test
    public void testCreateCar() {
        Car car = CarFactory.buildCar("123456", "13443975", "Ford", "Fiesta", "2016");
        ResponseEntity<Car> postResponse = restTemplate.postForEntity(baseURL + "/create", car, Car.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateCar() {
        int id = 1;
        Car car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);

        restTemplate.put(baseURL + "/car/" + id, car);
        Car updatedCar = restTemplate.getForObject(baseURL + "/Car/" + id, Car.class);
        assertNotNull(updatedCar);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Car car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);
        assertNotNull(car);
        restTemplate.delete(baseURL + "/car/" + id);
        try {
            car = restTemplate.getForObject(baseURL + "/car/" + id, Car.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
