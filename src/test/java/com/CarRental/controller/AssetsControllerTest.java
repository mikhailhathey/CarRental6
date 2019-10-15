package com.CarRental.controller;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AssetsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/assets";

    @Test
    public void testGetAllAssets() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAssetsById() {
        Assets assets = restTemplate.getForObject(BASE_URL + "/assets/1", Assets.class);
        System.out.println(assets.getAssetsId());
        assertNotNull(assets);
    }


    @Test
    public void createAssets() {
        Assets assets = AssetsFactory.buildAssets(456, "Volkswagen Polo", "Cape Town CBD", "Vehicle");
        ResponseEntity<Assets> result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/newAssets", assets, Assets.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result);
        assertNotNull(result.getBody());
    }

    @Test
    public void createUserAssets() {
        ResponseEntity<Assets> result = null;
        try{
            Assets assets = AssetsFactory.buildAssets(456, "Volkswagen Polo", "Cape Town CBD", "Vehicle");
            result = restTemplate.withBasicAuth("user", "user")
                    .postForEntity(BASE_URL + "/create/newAssets", assets, Assets.class);

        }catch (Exception e){
            System.out.println("Error from server : " + e.getMessage());

            assertNull("Successfully validated user not authenticated",result);
        }
        assertNull("Failed to validate user is not authenticated",result);
    }

    @Test
    public void testUpdateAssets() {
        int id = 1;
        Assets assets = restTemplate.getForObject(BASE_URL + "/assets/" + id, Assets.class);

        restTemplate.put(BASE_URL + "/assets/" + id, assets);
        Assets updatedAssets = restTemplate.getForObject(BASE_URL + "/assets/" + id, Assets.class);
        assertNotNull(updatedAssets);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Assets assets = restTemplate.getForObject(BASE_URL + "/assets/" + id, Assets.class);
        assertNotNull(assets);
        restTemplate.delete(BASE_URL + "/assets/" + id);
        try {
            assets = restTemplate.getForObject(BASE_URL + "/assets/" + id, Assets.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }


    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.FORBIDDEN, result.getStatusCode());
    }
}