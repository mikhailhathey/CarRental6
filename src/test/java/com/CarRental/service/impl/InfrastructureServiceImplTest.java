package com.CarRental.service.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.factories.InfrastructureFactory;
import com.CarRental.repositories.impl.InfrastructureRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InfrastructureServiceImplTest {

    private InfrastructureRepositoryImpl repository;
    private Infrastructure infrastructure;

    private Infrastructure getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.infrastructure);
    }

    @Test
    public void c_update() {
        String newInfrastructureName = "Application Development Theory 3";
        Infrastructure updated = new Infrastructure.Builder().copy(getSaved()).infrastructureId(newInfrastructureName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newInfrastructureName, updated.getInfrastructureId());
    }

    @Test
    public void e_delete() {
        Infrastructure saved = getSaved();
        this.repository.delete(saved.getInfrastructureId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Infrastructure saved = getSaved();
        Infrastructure read = this.repository.read(saved.getInfrastructureId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Infrastructure> infrastructures = this.repository.getAll();
        System.out.println("In getall, all = " + infrastructures);
    }
}
