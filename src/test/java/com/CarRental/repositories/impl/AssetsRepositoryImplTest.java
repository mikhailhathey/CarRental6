package com.CarRental.repositories.impl;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
import com.CarRental.repositories.AssetsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssetsRepositoryImplTest {

    private AssetsRepository assetsRepository;
    private Assets assets;

    private Assets getSavedAssets() {
        Set<Assets> savedAssets = this.assetsRepository.getAll();
        return savedAssets.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.assetsRepository = AssetsRepositoryImpl.getRepository();
        this.assets = AssetsFactory.buildAssets("456", "Volkswagen Polo", "Cape Town CBD", "Vehicle");
    }

    @Test
    public void a_create() {
        Assets created = this.assetsRepository.create(this.assets);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.assets);
    }
    @Test
    public void b_read() {
        Assets savedAssets = getSavedAssets();
        System.out.println("In read, assetsId = "+ savedAssets.getAssetsId());
        Assets read = this.assetsRepository.read(savedAssets.getAssetsId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAssets, read);
    }

    @Test
    public void e_delete() {
        Assets savedAssets = getSavedAssets();
        this.assetsRepository.delete(savedAssets.getAssetsId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Assets Name";
        Assets assets = new Assets.Builder().copy(getSavedAssets()).assetsId(newname).build();
        System.out.println("In update, about_to_updated = " + assets);
        Assets updated = this.assetsRepository.update(assets);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getAssetsId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assets> all = this.assetsRepository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertSame(2, all.size());
    }
}
