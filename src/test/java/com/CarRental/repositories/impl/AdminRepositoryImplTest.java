package com.CarRental.repositories.impl;

import com.CarRental.domain.Admin;
import com.CarRental.factories.AdminFactory;
import com.CarRental.repositories.AdminRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryImplTest {

    private AdminRepository repository;
    private Admin admin;

    private Admin getSavedAdmin() {
        Set<Admin> savedAdmins = this.repository.getAll();
        return savedAdmins.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.admin);
    }

    @Test
    public void b_read() {
       Admin savedAdmin = getSavedAdmin();
        System.out.println("In read, adminId = "+ savedAdmin.getAdminId());
        Admin read = this.repository.read(savedAdmin.getAdminId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAdmin, read);
    }

    @Test
    public void e_delete() {
        Admin savedAdmin = getSavedAdmin();
        this.repository.delete(savedAdmin.getAdminId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Admin Name";
        Admin admin = new Admin.Builder().copy(getSavedAdmin()).adminName(newname).build();
        System.out.println("In update, about_to_updated = " + admin);
        Admin updated = this.repository.update(admin);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Admin> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
