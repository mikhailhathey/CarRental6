package com.CarRental.factories;

import com.CarRental.domain.Expenses;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpensesFactoryTest {

    public void testBuildExpenses(){

    }

    private String ExpensesTest;

    @Before
    public void setUp() throws Exception {
        this.ExpensesTest = "ExpensesTest";
    }

    @Test
    public void buildExpenses() {
        Expenses expenses = ExpensesFactory.buildExpenses(123456, "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales");
        System.out.println(expenses);
        Assert.assertNotNull(expenses.getExpensesId());
    }
}