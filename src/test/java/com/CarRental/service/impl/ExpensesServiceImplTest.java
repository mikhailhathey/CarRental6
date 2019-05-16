package com.CarRental.service.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.factories.ExpensesFactory;
import com.CarRental.repositories.impl.ExpensesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpensesServiceImplTest {

    private ExpensesRepositoryImpl repository;
    private Expenses expenses;

    private Expenses getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.expenses);
    }

    @Test
    public void c_update() {
        String newExpensesName = "Application Development Theory 3";
        Expenses updated = new Expenses.Builder().copy(getSaved()).expensesId(newExpensesName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newExpensesName, updated.getExpensesId());
    }

    @Test
    public void e_delete() {
        Expenses saved = getSaved();
        this.repository.delete(saved.getExpensesId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Expenses saved = getSaved();
        Expenses read = this.repository.read(saved.getExpensesId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Expenses> expensess = this.repository.getAll();
        System.out.println("In getall, all = " + expensess);
    }
}
