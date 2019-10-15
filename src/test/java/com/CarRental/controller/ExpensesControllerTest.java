package com.CarRental.controller;

import com.CarRental.domain.Expenses;
import com.CarRental.factories.ExpensesFactory;
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
public class ExpensesControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/expenses";


    @Test
    public void testGetAllExpenses() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetExpensesById() {
        Expenses expenses = restTemplate.getForObject(baseURL + "/expenses/1", Expenses.class);
        System.out.println(expenses.getExpensesId());
        assertNotNull(expenses);
    }

    @Test
    public void testCreateExpenses() {
        Expenses expenses = ExpensesFactory.buildExpenses(123456, "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales");
        ResponseEntity<Expenses> postResponse = restTemplate.postForEntity(baseURL + "/create", expenses, Expenses.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateExpenses() {
        int id = 1;
        Expenses expenses = restTemplate.getForObject(baseURL + "/expenses/" + id, Expenses.class);

        restTemplate.put(baseURL + "/expenses/" + id, expenses);
        Expenses updatedExpenses = restTemplate.getForObject(baseURL + "/Expenses/" + id, Expenses.class);
        assertNotNull(updatedExpenses);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Expenses expenses = restTemplate.getForObject(baseURL + "/expenses/" + id, Expenses.class);
        assertNotNull(expenses);
        restTemplate.delete(baseURL + "/expenses/" + id);
        try {
            expenses = restTemplate.getForObject(baseURL + "/expenses/" + id, Expenses.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
