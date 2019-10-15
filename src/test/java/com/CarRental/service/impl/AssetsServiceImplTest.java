package com.CarRental.service.impl;

import com.CarRental.domain.Assets;
import com.CarRental.factories.AssetsFactory;
import com.CarRental.service.AssetsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AssetsServiceImplTest {
  @Autowired
  @Qualifier("AssetsServiceImpl")
  private AssetsService assetsService;
  private Assets assets;
  private Set<Assets> assetss = new HashSet<>();

  @Before
  public void setUp() {
      assets = assetsService.create(AssetsFactory.buildAssets(123, "DSLR Camera", "Cupboard", "Camera"));
      assetss.add(assets);
  }

  @Test
  public void create() {
      Assets createAssets = assetsService.create(AssetsFactory.buildAssets(
              456, "Drone", "Shelf", "Camera"));
      assetss.add(createAssets);
      Assert.assertEquals(createAssets, assetsService.read(createAssets.getAssetsId()));
  }

  @Test
  public void read() {
      Assets readTestAssets = assetsService.create(AssetsFactory.buildAssets(
              789, "GoPro", "Cabinet", "Camera"));
      Assert.assertEquals(readTestAssets, assetsService.read(readTestAssets.getAssetsId()));
  }

  @Test
  public void update() {
      String newAssetsName = "Test";
      Assets updateAssets = assetsService.update(new Assets.Builder().copy(assets).assetsName(newAssetsName).build());
      assetss.add(updateAssets);
      Assert.assertEquals(updateAssets, assetsService.read(updateAssets.getAssetsId()));
  }

  @Test
  public void delete() {
      assetss.addAll(assetsService.getAll());
      Assets deleteAssets = assetsService.create(AssetsFactory.buildAssets(123, "Point and Shoot", "Tabletop", "Camera"));
      assetss.add(deleteAssets);
      assetss.remove(deleteAssets);
      assetsService.delete(deleteAssets.getAssetsId());
      Assert.assertEquals(assetss.size(), assetsService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Assets> assetsSet = assetsService.getAll();
      Assert.assertEquals(assetsSet.size(), assetsService.getAll().size());
  }
}

//"123", "DSLR Camera", "Cupboard", "Camera"
