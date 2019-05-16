package com.CarRental.service.impl;

import com.CarRental.domain.Region;
import com.CarRental.factories.RegionFactory;
import com.CarRental.repositories.impl.RegionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegionServiceImplTest {

    private RegionRepositoryImpl repository;
    private Region region;

    private Region getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RegionRepositoryImpl.getRepository();
        this.region = RegionFactory.buildRegion("765", "Hatfield", "Pretoria");
    }

    @Test
    public void a_create() {
        Region created = this.repository.create(this.region);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.region);
    }

    @Test
    public void c_update() {
        String newRegionName = "Application Development Theory 3";
        Region updated = new Region.Builder().copy(getSaved()).regionId(newRegionName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newRegionName, updated.getRegionId());
    }

    @Test
    public void e_delete() {
        Region saved = getSaved();
        this.repository.delete(saved.getRegionId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Region saved = getSaved();
        Region read = this.repository.read(saved.getRegionId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Region> regions = this.repository.getAll();
        System.out.println("In getall, all = " + regions);
    }
}
