package com.CarRental.repositories.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.factories.PerishablesFactory;
import com.CarRental.repositories.PerishablesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerishablesRepositoryImplTest {

    private PerishablesRepository repository;
    private Perishables perishables;

    private Perishables getSavedPerishables() {
        Set<Perishables> savedPerishabless = this.repository.getAll();
        return savedPerishabless.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.perishables);
    }

    @Test
    public void b_read() {
       Perishables savedPerishables = getSavedPerishables();
        System.out.println("In read, perishablesId = "+ savedPerishables.getPerishablesId());
        Perishables read = this.repository.read(savedPerishables.getPerishablesId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPerishables, read);
    }

    @Test
    public void e_delete() {
        Perishables savedPerishables = getSavedPerishables();
        this.repository.delete(savedPerishables.getPerishablesId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Perishables Name";
        Perishables perishables = new Perishables.Builder().copy(getSavedPerishables()).perishableName(newname).build();
        System.out.println("In update, about_to_updated = " + perishables);
        Perishables updated = this.repository.update(perishables);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getPerishableName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Perishables> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
