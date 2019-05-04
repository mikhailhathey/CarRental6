package com.CarRental.repositories.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.factories.InfrastructureFactory;
import com.CarRental.repositories.InfrastructureRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InfrastructureRepositoryImplTest {

    private InfrastructureRepository repository;
    private Infrastructure infrastructure;

    private Infrastructure getSavedInfrastructure() {
        Set<Infrastructure> savedInfrastructures = this.repository.getAll();
        return savedInfrastructures.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = InfrastructureRepositoryImpl.getRepository();
        this.infrastructure = InfrastructureFactory.buildInfrastructure("789", "Dimension Data", "Network Servers", "50000");
    }

    @Test
    public void a_create() {
        Infrastructure created = this.repository.create(this.infrastructure);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.infrastructure);
    }

    @Test
    public void b_read() {
       Infrastructure savedInfrastructure = getSavedInfrastructure();
        System.out.println("In read, infrastructureId = "+ savedInfrastructure.getInfrastructureId());
        Infrastructure read = this.repository.read(savedInfrastructure.getInfrastructureId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedInfrastructure, read);
    }

    @Test
    public void e_delete() {
        Infrastructure savedInfrastructure = getSavedInfrastructure();
        this.repository.delete(savedInfrastructure.getInfrastructureId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Infrastructure Name";
        Infrastructure infrastructure = new Infrastructure.Builder().copy(getSavedInfrastructure()).infrastructureName(newname).build();
        System.out.println("In update, about_to_updated = " + infrastructure);
        Infrastructure updated = this.repository.update(infrastructure);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getInfrastructureName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Infrastructure> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
