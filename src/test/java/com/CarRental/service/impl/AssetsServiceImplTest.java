package com.CarRental.service.impl;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
import com.CarRental.repositories.impl.AssetsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssetsServiceImplTest {

    private AssetsRepositoryImpl repository;
    private Assets assets;

    private Assets getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.assets);
    }

    @Test
    public void c_update() {
        String newAssetsName = "Application Development Theory 3";
        Assets updated = new Assets.Builder().copy(getSaved()).assetsId(newAssetsName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAssetsName, updated.getAssetsId());
    }

    @Test
    public void e_delete() {
        Assets saved = getSaved();
        this.repository.delete(saved.getAssetsId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Assets saved = getSaved();
        Assets read = this.repository.read(saved.getAssetsId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Assets> assetss = this.repository.getAll();
        System.out.println("In getall, all = " + assetss);
    }
}
