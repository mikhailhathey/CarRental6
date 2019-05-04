package com.CarRental.repositories.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.factories.StaffTypeFactory;
import com.CarRental.repositories.StaffTypeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffTypeRepositoryImplTest {

    private StaffTypeRepository repository;
    private StaffType staffType;

    private StaffType getSavedStaffType() {
        Set<StaffType> savedStaffTypes = this.repository.getAll();
        return savedStaffTypes.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StaffTypeRepositoryImpl.getRepository();
        this.staffType = StaffTypeFactory.buildStaffType("765", "Customer Care", "200000");
    }

    @Test
    public void a_create() {
        StaffType created = this.repository.create(this.staffType);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.staffType);
    }

    @Test
    public void b_read() {
       StaffType savedStaffType = getSavedStaffType();
        System.out.println("In read, staffTypeId = "+ savedStaffType.getStaffTypeId());
        StaffType read = this.repository.read(savedStaffType.getStaffTypeId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStaffType, read);
    }

    @Test
    public void e_delete() {
        StaffType savedStaffType = getSavedStaffType();
        this.repository.delete(savedStaffType.getStaffTypeId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test StaffType Name";
        StaffType staffType = new StaffType.Builder().copy(getSavedStaffType()).staffTypeJobRole(newname).build();
        System.out.println("In update, about_to_updated = " + staffType);
        StaffType updated = this.repository.update(staffType);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getStaffTypeJobRole());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<StaffType> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
