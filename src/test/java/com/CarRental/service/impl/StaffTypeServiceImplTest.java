package com.CarRental.service.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.factories.StaffTypeFactory;
import com.CarRental.repositories.impl.StaffTypeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffTypeServiceImplTest {

    private StaffTypeRepositoryImpl repository;
    private StaffType staffType;

    private StaffType getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.staffType);
    }

    @Test
    public void c_update() {
        String newStaffTypeName = "Application Development Theory 3";
        StaffType updated = new StaffType.Builder().copy(getSaved()).staffTypeId(newStaffTypeName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStaffTypeName, updated.getStaffTypeId());
    }

    @Test
    public void e_delete() {
        StaffType saved = getSaved();
        this.repository.delete(saved.getStaffTypeId());
        d_getAll();
    }

    @Test
    public void b_read() {
        StaffType saved = getSaved();
        StaffType read = this.repository.read(saved.getStaffTypeId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<StaffType> staffTypes = this.repository.getAll();
        System.out.println("In getall, all = " + staffTypes);
    }
}
