package com.CarRental.repositories.impl;

import com.CarRental.domain.Profit;
import com.CarRental.factories.ProfitFactory;
import com.CarRental.repositories.ProfitRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfitRepositoryImplTest {

    private ProfitRepository repository;
    private Profit profit;

    private Profit getSavedProfit() {
        Set<Profit> savedProfits = this.repository.getAll();
        return savedProfits.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProfitRepositoryImpl.getRepository();
        this.profit = ProfitFactory.buildProfit("789", "100000", "120000");
    }

    @Test
    public void a_create() {
        Profit created = this.repository.create(this.profit);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.profit);
    }

    @Test
    public void b_read() {
       Profit savedProfit = getSavedProfit();
        System.out.println("In read, profitId = "+ savedProfit.getProfitId());
        Profit read = this.repository.read(savedProfit.getProfitId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedProfit, read);
    }

    @Test
    public void e_delete() {
        Profit savedProfit = getSavedProfit();
        this.repository.delete(savedProfit.getProfitId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Profit Name";
        Profit profit = new Profit.Builder().copy(getSavedProfit()).profitActual(newname).build();
        System.out.println("In update, about_to_updated = " + profit);
        Profit updated = this.repository.update(profit);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getProfitActual());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Profit> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
