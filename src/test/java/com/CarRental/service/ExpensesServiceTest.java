package com.CarRental.service;

import com.CarRental.domain.Expenses;
import com.CarRental.factories.ExpensesFactory;
import com.CarRental.repositories.impl.ExpensesRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class ExpensesServiceTest {

    private ExpensesRepositoryImpl repository;
    private Expenses expenses;


    @Before
    public void setUp() throws Exception {
        this.repository = ExpensesRepositoryImpl.getRepository();
        this.expenses = ExpensesFactory.buildExpenses("123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales");
    }

    @Test
    public void getAll() {
        Set<Expenses> expenses = this.repository.getAll();
        System.out.println("In getall, all = " + expenses);
    }

}
