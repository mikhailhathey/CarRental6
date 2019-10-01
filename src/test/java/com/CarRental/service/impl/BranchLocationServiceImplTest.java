package com.CarRental.service.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.factories.BranchLocationFactory;
import com.CarRental.service.BranchLocationService;
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
public class BranchLocationServiceImplTest {
  @Autowired
  @Qualifier("BranchLocationServiceImpl")
  private BranchLocationService branchLocationService;
  private BranchLocation branchLocation;
  private Set<BranchLocation> branchLocations = new HashSet<>();

  @Before
  public void setUp() {
      branchLocation = branchLocationService.create(BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager"));
      branchLocations.add(branchLocation);
  }

  @Test
  public void create() {
      BranchLocation createBranchLocation = branchLocationService.create(BranchLocationFactory.buildBranchLocation(
              "123", "TestBranch", "TestManager"));
      branchLocations.add(createBranchLocation);
      Assert.assertEquals(createBranchLocation, branchLocationService.read(createBranchLocation.getBranchLocationId()));
  }

  @Test
  public void read() {
      BranchLocation readTestBranchLocation = branchLocationService.create(BranchLocationFactory.buildBranchLocation(
              "123", "TestBranch", "TestManager"));
      Assert.assertEquals(readTestBranchLocation, branchLocationService.read(readTestBranchLocation.getBranchLocationId()));
  }

  @Test
  public void update() {
      String newBranchName = "Test";
      BranchLocation updateBranchLocation = branchLocationService.update(new BranchLocation.Builder().copy(branchLocation).branchName(newBranchName).build());
      branchLocations.add(updateBranchLocation);
      Assert.assertEquals(updateBranchLocation, branchLocationService.read(updateBranchLocation.getBranchLocationId()));
  }

  @Test
  public void delete() {
      branchLocations.addAll(branchLocationService.getAll());
      BranchLocation deleteBranchLocation = branchLocationService.create(BranchLocationFactory.buildBranchLocation("123", "TestBranch", "TestManager"));
      branchLocations.add(deleteBranchLocation);
      branchLocations.remove(deleteBranchLocation);
      branchLocationService.delete(deleteBranchLocation.getBranchLocationId());
      Assert.assertEquals(branchLocations.size(), branchLocationService.getAll().size());
  }

  @Test
  public void getAll() {
      List<BranchLocation> branchLocationSet = branchLocationService.getAll();
      Assert.assertEquals(branchLocationSet.size(), branchLocationService.getAll().size());
  }
}
//"123", "TestBranch", "TestManager"
