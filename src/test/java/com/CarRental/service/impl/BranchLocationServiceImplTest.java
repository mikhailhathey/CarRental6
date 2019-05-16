package com.CarRental.service.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.factories.BranchLocationFactory;
import com.CarRental.repositories.impl.BranchLocationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BranchLocationServiceImplTest {

    private BranchLocationRepositoryImpl repository;
    private BranchLocation branchLocation;

    private BranchLocation getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BranchLocationRepositoryImpl.getRepository();
        this.branchLocation = BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager");
    }

    @Test
    public void a_create() {
        BranchLocation created = this.repository.create(this.branchLocation);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.branchLocation);
    }

    @Test
    public void c_update() {
        String newBranchLocationName = "Application Development Theory 3";
        BranchLocation updated = new BranchLocation.Builder().copy(getSaved()).branchLocationId(newBranchLocationName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newBranchLocationName, updated.getBranchLocationId());
    }

    @Test
    public void e_delete() {
        BranchLocation saved = getSaved();
        this.repository.delete(saved.getBranchLocationId());
        d_getAll();
    }

    @Test
    public void b_read() {
        BranchLocation saved = getSaved();
        BranchLocation read = this.repository.read(saved.getBranchLocationId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<BranchLocation> branchLocations = this.repository.getAll();
        System.out.println("In getall, all = " + branchLocations);
    }
}
