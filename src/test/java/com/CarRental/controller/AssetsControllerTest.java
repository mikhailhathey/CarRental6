package com.CarRental.controller;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
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
public class AssetsControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/assets";


    @Test
    public void testGetAllAssets() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetAssetsById() {
        Assets assets = restTemplate.getForObject(baseURL + "/assets/1", Assets.class);
        System.out.println(assets.getAssetsId());
        assertNotNull(assets);
    }

    @Ignore
    public void testCreateAssets() {
        Assets assets = AssetsFactory.buildAssets("123", "DSLR Camera", "Cupboard", "Camera");
        ResponseEntity<Assets> postResponse = restTemplate.postForEntity(baseURL + "/create", assets, Assets.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAssets() {
        int id = 1;
        Assets assets = restTemplate.getForObject(baseURL + "/assets/" + id, Assets.class);

        restTemplate.put(baseURL + "/assets/" + id, assets);
        Assets updatedAssets = restTemplate.getForObject(baseURL + "/Assets/" + id, Assets.class);
        assertNotNull(updatedAssets);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Assets assets = restTemplate.getForObject(baseURL + "/assets/" + id, Assets.class);
        assertNotNull(assets);
        restTemplate.delete(baseURL + "/assets/" + id);
        try {
            assets = restTemplate.getForObject(baseURL + "/assets/" + id, Assets.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
