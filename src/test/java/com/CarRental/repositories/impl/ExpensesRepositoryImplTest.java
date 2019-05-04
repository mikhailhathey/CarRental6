package com.CarRental.repositories.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.factories.ExpensesFactory;
import com.CarRental.repositories.ExpensesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpensesRepositoryImplTest {

    private ExpensesRepository repository;
    private Expenses expenses;

    private Expenses getSavedExpenses() {
        Set<Expenses> savedExpensess = this.repository.getAll();
        return savedExpensess.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ExpensesRepositoryImpl.getRepository();
        this.expenses = ExpensesFactory.buildExpenses("123456", "12000", "24/03/2019", "Fiesta@ford.co.za", "Sales");
    }

    @Test
    public void a_create() {
        Expenses created = this.repository.create(this.expenses);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.expenses);
    }

    @Test
    public void b_read() {
       Expenses savedExpenses = getSavedExpenses();
        System.out.println("In read, expensesId = "+ savedExpenses.getExpensesId());
        Expenses read = this.repository.read(savedExpenses.getExpensesId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedExpenses, read);
    }

    @Test
    public void e_delete() {
        Expenses savedExpenses = getSavedExpenses();
        this.repository.delete(savedExpenses.getExpensesId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Expenses Name";
        Expenses expenses = new Expenses.Builder().copy(getSavedExpenses()).expensesContact(newname).build();
        System.out.println("In update, about_to_updated = " + expenses);
        Expenses updated = this.repository.update(expenses);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getExpensesContact());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Expenses> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
