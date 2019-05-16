package com.CarRental.service.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.factories.HardwareFactory;
import com.CarRental.repositories.impl.HardwareRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardwareServiceImplTest {

    private HardwareRepositoryImpl repository;
    private Hardware hardware;

    private Hardware getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = HardwareRepositoryImpl.getRepository();
        this.hardware = HardwareFactory.buildHardware("456", "Laptop", "4500");
    }

    @Test
    public void a_create() {
        Hardware created = this.repository.create(this.hardware);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.hardware);
    }

    @Test
    public void c_update() {
        String newHardwareName = "Application Development Theory 3";
        Hardware updated = new Hardware.Builder().copy(getSaved()).hardwareId(newHardwareName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newHardwareName, updated.getHardwareId());
    }

    @Test
    public void e_delete() {
        Hardware saved = getSaved();
        this.repository.delete(saved.getHardwareId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Hardware saved = getSaved();
        Hardware read = this.repository.read(saved.getHardwareId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Hardware> hardwares = this.repository.getAll();
        System.out.println("In getall, all = " + hardwares);
    }
}
