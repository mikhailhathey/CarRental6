package com.CarRental.repositories.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.factories.HardwareFactory;
import com.CarRental.repositories.HardwareRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardwareRepositoryImplTest {

    private HardwareRepository repository;
    private Hardware hardware;

    private Hardware getSavedHardware() {
        Set<Hardware> savedHardwares = this.repository.getAll();
        return savedHardwares.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.hardware);
    }

    @Test
    public void b_read() {
       Hardware savedHardware = getSavedHardware();
        System.out.println("In read, hardwareId = "+ savedHardware.getHardwareId());
        Hardware read = this.repository.read(savedHardware.getHardwareId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedHardware, read);
    }

    @Test
    public void e_delete() {
        Hardware savedHardware = getSavedHardware();
        this.repository.delete(savedHardware.getHardwareId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Hardware Name";
        Hardware hardware = new Hardware.Builder().copy(getSavedHardware()).hardwareName(newname).build();
        System.out.println("In update, about_to_updated = " + hardware);
        Hardware updated = this.repository.update(hardware);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getHardwareName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Hardware> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
