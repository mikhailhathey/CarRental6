package com.CarRental.factories;

import com.CarRental.domain.StaffType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTypeFactoryTest {

    public void testBuildStaffType(){

    }

    private String StaffTypeTest;

    @Before
    public void setUp() throws Exception {
        this.StaffTypeTest = "StaffTypeTest";
    }

    @Test
    public void buildStaffType() {
        StaffType staffType = StaffTypeFactory.buildStaffType(765, "Customer Care", "200000");
        System.out.println(staffType);
        Assert.assertNotNull(staffType.getStaffTypeId());
    }
}
