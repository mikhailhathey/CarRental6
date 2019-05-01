package com.CarRental.factories;

import com.CarRental.domain.BranchLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BranchLocationFactoryTest {

    public void testBuildBranchLocation() {
    }

    private String BranchLocationTest;

    @Before
    public void setUp() throws Exception {
        this.BranchLocationTest = "BranchLocationTest";
    }

    @Test
    public void buildBranchLocation() {
        BranchLocation branchLocation = BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager");
        System.out.println(branchLocation);
        Assert.assertNotNull(branchLocation.getBranchLocationId());
    }
}