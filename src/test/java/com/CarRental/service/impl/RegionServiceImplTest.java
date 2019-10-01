package com.CarRental.service.impl;

import com.CarRental.domain.Region;
import com.CarRental.factories.RegionFactory;
import com.CarRental.service.RegionService;
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
public class RegionServiceImplTest {
  @Autowired
  @Qualifier("RegionServiceImpl")
  private RegionService regionService;
  private Region region;
  private Set<Region> regions = new HashSet<>();

  @Before
  public void setUp() {
      region = regionService.create(RegionFactory.buildRegion("765", "Hatfield", "Pretoria"));
      regions.add(region);
  }

  @Test
  public void create() {
      Region createRegion = regionService.create(RegionFactory.buildRegion(
              "765", "Hatfield", "Pretoria"));
      regions.add(createRegion);
      Assert.assertEquals(createRegion, regionService.read(createRegion.getRegionId()));
  }

  @Test
  public void read() {
      Region readTestRegion = regionService.create(RegionFactory.buildRegion(
              "765", "Hatfield", "Pretoria"));
      Assert.assertEquals(readTestRegion, regionService.read(readTestRegion.getRegionId()));
  }

  @Test
  public void update() {
      String newRegionName = "Test";
      Region updateRegion = regionService.update(new Region.Builder().copy(region).regionName(newRegionName).build());
      regions.add(updateRegion);
      Assert.assertEquals(updateRegion, regionService.read(updateRegion.getRegionId()));
  }

  @Test
  public void delete() {
      regions.addAll(regionService.getAll());
      Region deleteRegion = regionService.create(RegionFactory.buildRegion("765", "Hatfield", "Pretoria"));
      regions.add(deleteRegion);
      regions.remove(deleteRegion);
      regionService.delete(deleteRegion.getRegionId());
      Assert.assertEquals(regions.size(), regionService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Region> regionSet = regionService.getAll();
      Assert.assertEquals(regionSet.size(), regionService.getAll().size());
  }
}
//"765", "Hatfield", "Pretoria"
