package com.CarRental.repositories.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.factories.BranchLocationFactory;
import com.CarRental.repositories.BranchLocationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BranchLocationRepositoryImplTest {

    private BranchLocationRepository repository;
    private BranchLocation branchLocation;

    private BranchLocation getSavedBranchLocation() {
        Set<BranchLocation> savedBranchLocations = this.repository.getAll();
        return savedBranchLocations.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.branchLocation);
    }

    @Test
    public void b_read() {
       BranchLocation savedBranchLocation = getSavedBranchLocation();
        System.out.println("In read, branchLocationId = "+ savedBranchLocation.getBranchLocationId());
        BranchLocation read = this.repository.read(savedBranchLocation.getBranchLocationId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedBranchLocation, read);
    }

    @Test
    public void e_delete() {
        BranchLocation savedBranchLocation = getSavedBranchLocation();
        this.repository.delete(savedBranchLocation.getBranchLocationId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test BranchLocation Name";
        BranchLocation branchLocation = new BranchLocation.Builder().copy(getSavedBranchLocation()).branchName(newname).build();
        System.out.println("In update, about_to_updated = " + branchLocation);
        BranchLocation updated = this.repository.update(branchLocation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getBranchName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<BranchLocation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
