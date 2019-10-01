package com.CarRental.service.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.factories.StaffTypeFactory;
import com.CarRental.service.StaffTypeService;
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
public class StaffTypeServiceImplTest {
  @Autowired
  @Qualifier("StaffTypeServiceImpl")
  private StaffTypeService staffTypeService;
  private StaffType staffType;
  private Set<StaffType> staffTypes = new HashSet<>();

  @Before
  public void setUp() {
      staffType = staffTypeService.create(StaffTypeFactory.buildStaffType("765", "Customer Care", "200000"));
      staffTypes.add(staffType);
  }

  @Test
  public void create() {
      StaffType createStaffType = staffTypeService.create(StaffTypeFactory.buildStaffType(
              "765", "Customer Care", "200000"));
      staffTypes.add(createStaffType);
      Assert.assertEquals(createStaffType, staffTypeService.read(createStaffType.getStaffTypeId()));
  }

  @Test
  public void read() {
      StaffType readTestStaffType = staffTypeService.create(StaffTypeFactory.buildStaffType(
              "765", "Customer Care", "200000"));
      Assert.assertEquals(readTestStaffType, staffTypeService.read(readTestStaffType.getStaffTypeId()));
  }

  @Test
  public void update() {
      String newStaffTypeRole = "Test";
      StaffType updateStaffType = staffTypeService.update(new StaffType.Builder().copy(staffType).staffTypeJobRole(newStaffTypeRole).build());
      staffTypes.add(updateStaffType);
      Assert.assertEquals(updateStaffType, staffTypeService.read(updateStaffType.getStaffTypeId()));
  }

  @Test
  public void delete() {
      staffTypes.addAll(staffTypeService.getAll());
      StaffType deleteStaffType = staffTypeService.create(StaffTypeFactory.buildStaffType("765", "Customer Care", "200000"));
      staffTypes.add(deleteStaffType);
      staffTypes.remove(deleteStaffType);
      staffTypeService.delete(deleteStaffType.getStaffTypeId());
      Assert.assertEquals(staffTypes.size(), staffTypeService.getAll().size());
  }

  @Test
  public void getAll() {
      List<StaffType> staffTypeSet = staffTypeService.getAll();
      Assert.assertEquals(staffTypeSet.size(), staffTypeService.getAll().size());
  }
}
//"765", "Customer Care", "200000"
