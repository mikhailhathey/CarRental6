package com.CarRental.service.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.factories.FleetManagerFactory;
import com.CarRental.repositories.impl.FleetManagerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FleetManagerServiceImplTest {

    private FleetManagerRepositoryImpl repository;
    private FleetManager fleetManager;

    private FleetManager getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = FleetManagerRepositoryImpl.getRepository();
        this.fleetManager = FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth");
    }

    @Test
    public void a_create() {
        FleetManager created = this.repository.create(this.fleetManager);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.fleetManager);
    }

    @Test
    public void c_update() {
        String newFleetManagerName = "Application Development Theory 3";
        FleetManager updated = new FleetManager.Builder().copy(getSaved()).fleetManagerId(newFleetManagerName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newFleetManagerName, updated.getFleetManagerId());
    }

    @Test
    public void e_delete() {
        FleetManager saved = getSaved();
        this.repository.delete(saved.getFleetManagerId());
        d_getAll();
    }

    @Test
    public void b_read() {
        FleetManager saved = getSaved();
        FleetManager read = this.repository.read(saved.getFleetManagerId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<FleetManager> fleetManagers = this.repository.getAll();
        System.out.println("In getall, all = " + fleetManagers);
    }
}
