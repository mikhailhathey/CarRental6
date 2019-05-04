package com.CarRental.repositories.impl;

import com.CarRental.domain.Staff;
import com.CarRental.factories.StaffFactory;
import com.CarRental.repositories.StaffRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffRepositoryImplTest {

    private StaffRepository repository;
    private Staff staff;

    private Staff getSavedStaff() {
        Set<Staff> savedStaffs = this.repository.getAll();
        return savedStaffs.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.staff);
    }

    @Test
    public void b_read() {
       Staff savedStaff = getSavedStaff();
        System.out.println("In read, staffId = "+ savedStaff.getStaffId());
        Staff read = this.repository.read(savedStaff.getStaffId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStaff, read);
    }

    @Test
    public void e_delete() {
        Staff savedStaff = getSavedStaff();
        this.repository.delete(savedStaff.getStaffId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Staff Name";
        Staff staff = new Staff.Builder().copy(getSavedStaff()).staffName(newname).build();
        System.out.println("In update, about_to_updated = " + staff);
        Staff updated = this.repository.update(staff);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getStaffName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Staff> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
