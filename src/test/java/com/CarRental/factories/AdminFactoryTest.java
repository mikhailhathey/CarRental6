package com.CarRental.factories;

import com.CarRental.domain.Admin;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminFactoryTest extends TestCase {

    public void testBuildAdmin() {
    }

    private String AdminTest;

    @Before
    public void setUp() throws Exception {
        this.AdminTest = "AdminTest";
    }

    @Test
    public void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin("123", "AdminUser", "Password123");
        System.out.println(admin);
        Assert.assertNotNull(admin.getAdminId());
    }
}