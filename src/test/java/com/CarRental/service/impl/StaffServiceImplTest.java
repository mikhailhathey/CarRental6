package com.CarRental.service.impl;

import com.CarRental.domain.Staff;
import com.CarRental.factories.StaffFactory;
import com.CarRental.repositories.impl.StaffRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffServiceImplTest {

    private StaffRepositoryImpl repository;
    private Staff staff;

    private Staff getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StaffRepositoryImpl.getRepository();
        this.staff = StaffFactory.buildStaff("345", "August", "April", "200000", "Claremont");
    }

    @Test
    public void a_create() {
        Staff created = this.repository.create(this.staff);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.staff);
    }

    @Test
    public void c_update() {
        String newStaffName = "Application Development Theory 3";
        Staff updated = new Staff.Builder().copy(getSaved()).staffId(newStaffName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStaffName, updated.getStaffId());
    }

    @Test
    public void e_delete() {
        Staff saved = getSaved();
        this.repository.delete(saved.getStaffId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Staff saved = getSaved();
        Staff read = this.repository.read(saved.getStaffId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Staff> staffs = this.repository.getAll();
        System.out.println("In getall, all = " + staffs);
    }
}
