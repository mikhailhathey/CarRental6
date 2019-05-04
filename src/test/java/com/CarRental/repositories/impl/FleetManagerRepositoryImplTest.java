package com.CarRental.repositories.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.factories.FleetManagerFactory;
import com.CarRental.repositories.FleetManagerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FleetManagerRepositoryImplTest {

    private FleetManagerRepository repository;
    private FleetManager fleetManager;

    private FleetManager getSavedFleetManager() {
        Set<FleetManager> savedFleetManagers = this.repository.getAll();
        return savedFleetManagers.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.fleetManager);
    }

    @Test
    public void b_read() {
       FleetManager savedFleetManager = getSavedFleetManager();
        System.out.println("In read, fleetManagerId = "+ savedFleetManager.getFleetManagerId());
        FleetManager read = this.repository.read(savedFleetManager.getFleetManagerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedFleetManager, read);
    }

    @Test
    public void e_delete() {
        FleetManager savedFleetManager = getSavedFleetManager();
        this.repository.delete(savedFleetManager.getFleetManagerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test FleetManager Name";
        FleetManager fleetManager = new FleetManager.Builder().copy(getSavedFleetManager()).fleetManagerBranch(newname).build();
        System.out.println("In update, about_to_updated = " + fleetManager);
        FleetManager updated = this.repository.update(fleetManager);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getFleetManagerBranch());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<FleetManager> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
