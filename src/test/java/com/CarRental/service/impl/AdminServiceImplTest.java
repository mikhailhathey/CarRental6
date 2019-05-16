package com.CarRental.service.impl;

import com.CarRental.domain.Admin;
import com.CarRental.factories.AdminFactory;
import com.CarRental.repositories.impl.AdminRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceImplTest {

    private AdminRepositoryImpl repository;
    private Admin admin;

    private Admin getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AdminRepositoryImpl.getRepository();
        this.admin = AdminFactory.buildAdmin("123", "AdminUser", "Password123");
    }

    @Test
    public void a_create() {
        Admin created = this.repository.create(this.admin);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.admin);
    }

    @Test
    public void c_update() {
        String newAdminName = "Application Development Theory 3";
        Admin updated = new Admin.Builder().copy(getSaved()).adminId(newAdminName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAdminName, updated.getAdminId());
    }

    @Test
    public void e_delete() {
        Admin saved = getSaved();
        this.repository.delete(saved.getAdminId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Admin saved = getSaved();
        Admin read = this.repository.read(saved.getAdminId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Admin> admins = this.repository.getAll();
        System.out.println("In getall, all = " + admins);
    }
}
