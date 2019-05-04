package com.CarRental.repositories.impl;

import com.CarRental.domain.Region;
import com.CarRental.factories.RegionFactory;
import com.CarRental.repositories.RegionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegionRepositoryImplTest {

    private RegionRepository repository;
    private Region region;

    private Region getSavedRegion() {
        Set<Region> savedRegions = this.repository.getAll();
        return savedRegions.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.region);
    }

    @Test
    public void b_read() {
       Region savedRegion = getSavedRegion();
        System.out.println("In read, regionId = "+ savedRegion.getRegionId());
        Region read = this.repository.read(savedRegion.getRegionId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRegion, read);
    }

    @Test
    public void e_delete() {
        Region savedRegion = getSavedRegion();
        this.repository.delete(savedRegion.getRegionId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Region Name";
        Region region = new Region.Builder().copy(getSavedRegion()).regionName(newname).build();
        System.out.println("In update, about_to_updated = " + region);
        Region updated = this.repository.update(region);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getRegionName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Region> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
