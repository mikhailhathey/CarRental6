package com.CarRental.repositories.impl;

import com.CarRental.domain.Software;
import com.CarRental.factories.SoftwareFactory;
import com.CarRental.repositories.SoftwareRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SoftwareRepositoryImplTest {

    private SoftwareRepository repository;
    private Software software;

    private Software getSavedSoftware() {
        Set<Software> savedSoftwares = this.repository.getAll();
        return savedSoftwares.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.software);
    }

    @Test
    public void b_read() {
       Software savedSoftware = getSavedSoftware();
        System.out.println("In read, softwareId = "+ savedSoftware.getSoftwareId());
        Software read = this.repository.read(savedSoftware.getSoftwareId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSoftware, read);
    }

    @Test
    public void e_delete() {
        Software savedSoftware = getSavedSoftware();
        this.repository.delete(savedSoftware.getSoftwareId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Software Name";
        Software software = new Software.Builder().copy(getSavedSoftware()).softwareName(newname).build();
        System.out.println("In update, about_to_updated = " + software);
        Software updated = this.repository.update(software);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSoftwareName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Software> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
