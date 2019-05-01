package com.CarRental.factories;

import com.CarRental.domain.Staff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffFactoryTest {

    public void testBuildStaff(){

    }

    private String StaffTest;

    @Before
    public void setUp() throws Exception {
        this.StaffTest = "StaffTest";
    }

    @Test
    public void buildStaff() {
        Staff staff = StaffFactory.buildStaff("345", "August", "April", "200000", "Claremont");
        System.out.println(staff);
        Assert.assertNotNull(staff.getStaffId());
    }
}