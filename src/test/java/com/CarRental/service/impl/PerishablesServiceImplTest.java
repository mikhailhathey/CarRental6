package com.CarRental.service.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.factories.PerishablesFactory;
import com.CarRental.repositories.impl.PerishablesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerishablesServiceImplTest {

    private PerishablesRepositoryImpl repository;
    private Perishables perishables;

    private Perishables getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PerishablesRepositoryImpl.getRepository();
        this.perishables = PerishablesFactory.buildPerishables("567", "Bread", "12/05/2019", "5");
    }

    @Test
    public void a_create() {
        Perishables created = this.repository.create(this.perishables);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.perishables);
    }

    @Test
    public void c_update() {
        String newPerishablesName = "Application Development Theory 3";
        Perishables updated = new Perishables.Builder().copy(getSaved()).perishablesId(newPerishablesName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newPerishablesName, updated.getPerishablesId());
    }

    @Test
    public void e_delete() {
        Perishables saved = getSaved();
        this.repository.delete(saved.getPerishablesId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Perishables saved = getSaved();
        Perishables read = this.repository.read(saved.getPerishablesId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Perishables> perishabless = this.repository.getAll();
        System.out.println("In getall, all = " + perishabless);
    }
}
