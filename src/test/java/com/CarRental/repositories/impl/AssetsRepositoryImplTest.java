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

    private AssetsRepository repository;
    private Assets assets;

    private Assets getSavedAssets() {
        Set<Assets> savedAssetss = this.repository.getAll();
        return savedAssetss.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssetsRepositoryImpl.getRepository();
        this.assets = AssetsFactory.buildAssets("123", "DSLR Camera", "Cupboard", "Camera");
    }

    @Test
    public void a_create() {
        Assets created = this.repository.create(this.assets);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.assets);
    }

    @Test
    public void b_read() {
       Assets savedAssets = getSavedAssets();
        System.out.println("In read, assetsId = "+ savedAssets.getAssetsId());
        Assets read = this.repository.read(savedAssets.getAssetsId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAssets, read);
    }

    @Test
    public void e_delete() {
        Assets savedAssets = getSavedAssets();
        this.repository.delete(savedAssets.getAssetsId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Assets Name";
        Assets assets = new Assets.Builder().copy(getSavedAssets()).assetsName(newname).build();
        System.out.println("In update, about_to_updated = " + assets);
        Assets updated = this.repository.update(assets);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getAssetsName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assets> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
