package com.CarRental.service.impl;

import com.CarRental.domain.Profit;
import com.CarRental.factories.ProfitFactory;
import com.CarRental.repositories.impl.ProfitRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfitServiceImplTest {

    private ProfitRepositoryImpl repository;
    private Profit profit;

    private Profit getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.profit);
    }

    @Test
    public void c_update() {
        String newProfitName = "Application Development Theory 3";
        Profit updated = new Profit.Builder().copy(getSaved()).profitId(newProfitName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newProfitName, updated.getProfitId());
    }

    @Test
    public void e_delete() {
        Profit saved = getSaved();
        this.repository.delete(saved.getProfitId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Profit saved = getSaved();
        Profit read = this.repository.read(saved.getProfitId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Profit> profits = this.repository.getAll();
        System.out.println("In getall, all = " + profits);
    }
}
