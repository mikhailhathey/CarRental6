package com.CarRental.service.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.factories.ExpensesFactory;
import com.CarRental.service.ExpensesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExpensesServiceImplTest {
  @Autowired
  @Qualifier("ExpensesServiceImpl")
  private ExpensesService expensesService;
  private Expenses expenses;
  private Set<Expenses> expensess = new HashSet<>();

  @Before
  public void setUp() {
      expenses = expensesService.create(ExpensesFactory.buildExpenses("123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales"));
      expensess.add(expenses);
  }

  @Test
  public void create() {
      Expenses createExpenses = expensesService.create(ExpensesFactory.buildExpenses(
              "123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales"));
      expensess.add(createExpenses);
      Assert.assertEquals(createExpenses, expensesService.read(createExpenses.getExpensesId()));
  }

  @Test
  public void read() {
      Expenses readTestExpenses = expensesService.create(ExpensesFactory.buildExpenses(
              "123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales"));
      Assert.assertEquals(readTestExpenses, expensesService.read(readTestExpenses.getExpensesId()));
  }

  @Test
  public void update() {
      String newExpenseContactName = "Test";
      Expenses updateExpenses = expensesService.update(new Expenses.Builder().copy(expenses).expensesContact(newExpenseContactName).build());
      expensess.add(updateExpenses);
      Assert.assertEquals(updateExpenses, expensesService.read(updateExpenses.getExpensesId()));
  }

  @Test
  public void delete() {
      expensess.addAll(expensesService.getAll());
      Expenses deleteExpenses = expensesService.create(ExpensesFactory.buildExpenses("123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales"));
      expensess.add(deleteExpenses);
      expensess.remove(deleteExpenses);
      expensesService.delete(deleteExpenses.getExpensesId());
      Assert.assertEquals(expensess.size(), expensesService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Expenses> expensesSet = expensesService.getAll();
      Assert.assertEquals(expensesSet.size(), expensesService.getAll().size());
  }
}
//"123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales"
