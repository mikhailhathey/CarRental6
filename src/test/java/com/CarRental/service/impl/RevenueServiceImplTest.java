package com.CarRental.service.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.factories.RevenueFactory;
import com.CarRental.repositories.impl.RevenueRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RevenueServiceImplTest {

    private RevenueRepositoryImpl repository;
    private Revenue revenue;

    private Revenue getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.revenue);
    }

    @Test
    public void c_update() {
        String newRevenueName = "Application Development Theory 3";
        Revenue updated = new Revenue.Builder().copy(getSaved()).revenueId(newRevenueName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newRevenueName, updated.getRevenueId());
    }

    @Test
    public void e_delete() {
        Revenue saved = getSaved();
        this.repository.delete(saved.getRevenueId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Revenue saved = getSaved();
        Revenue read = this.repository.read(saved.getRevenueId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Revenue> revenues = this.repository.getAll();
        System.out.println("In getall, all = " + revenues);
    }
}
