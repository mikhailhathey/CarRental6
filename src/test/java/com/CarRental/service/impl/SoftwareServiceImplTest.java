package com.CarRental.service.impl;

import com.CarRental.domain.Software;
import com.CarRental.factories.SoftwareFactory;
import com.CarRental.repositories.impl.SoftwareRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SoftwareServiceImplTest {

    private SoftwareRepositoryImpl repository;
    private Software software;

    private Software getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SoftwareRepositoryImpl.getRepository();
        this.software = SoftwareFactory.buildSoftware("769", "Pascal", "2.6", "3000");
    }

    @Test
    public void a_create() {
        Software created = this.repository.create(this.software);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.software);
    }

    @Test
    public void c_update() {
        String newSoftwareName = "Application Development Theory 3";
        Software updated = new Software.Builder().copy(getSaved()).softwareId(newSoftwareName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSoftwareName, updated.getSoftwareId());
    }

    @Test
    public void e_delete() {
        Software saved = getSaved();
        this.repository.delete(saved.getSoftwareId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Software saved = getSaved();
        Software read = this.repository.read(saved.getSoftwareId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Software> softwares = this.repository.getAll();
        System.out.println("In getall, all = " + softwares);
    }
}
