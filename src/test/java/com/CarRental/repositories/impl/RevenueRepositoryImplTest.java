package com.CarRental.repositories.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.factories.RevenueFactory;
import com.CarRental.repositories.RevenueRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RevenueRepositoryImplTest {

    private RevenueRepository repository;
    private Revenue revenue;

    private Revenue getSavedRevenue() {
        Set<Revenue> savedRevenues = this.repository.getAll();
        return savedRevenues.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RevenueRepositoryImpl.getRepository();
        this.revenue = RevenueFactory.buildRevenue("345", "August", "April", "200000", "Claremont");
    }

    @Test
    public void a_create() {
        Revenue created = this.repository.create(this.revenue);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.revenue);
    }

    @Test
    public void b_read() {
       Revenue savedRevenue = getSavedRevenue();
        System.out.println("In read, revenueId = "+ savedRevenue.getRevenueId());
        Revenue read = this.repository.read(savedRevenue.getRevenueId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRevenue, read);
    }

    @Test
    public void e_delete() {
        Revenue savedRevenue = getSavedRevenue();
        this.repository.delete(savedRevenue.getRevenueId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Revenue Name";
        Revenue revenue = new Revenue.Builder().copy(getSavedRevenue()).revenueAmount(newname).build();
        System.out.println("In update, about_to_updated = " + revenue);
        Revenue updated = this.repository.update(revenue);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getRevenueAmount());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Revenue> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
