package com.CarRental.service.impl;

import com.CarRental.domain.Staff;
import com.CarRental.factories.StaffFactory;
import com.CarRental.service.StaffService;
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
public class StaffServiceImplTest {
  @Autowired
  @Qualifier("StaffServiceImpl")
  private StaffService staffService;
  private Staff staff;
  private Set<Staff> staffs = new HashSet<>();

  @Before
  public void setUp() {
      staff = staffService.create(StaffFactory.buildStaff(345, "August", "April", "200000", "Claremont"));
      staffs.add(staff);
  }

  @Test
  public void create() {
      Staff createStaff = staffService.create(StaffFactory.buildStaff(
              345, "August", "April", "200000", "Claremont"));
      staffs.add(createStaff);
      Assert.assertEquals(createStaff, staffService.read(createStaff.getStaffId()));
  }

  @Test
  public void read() {
      Staff readTestStaff = staffService.create(StaffFactory.buildStaff(
              345, "August", "April", "200000", "Claremont"));
      Assert.assertEquals(readTestStaff, staffService.read(readTestStaff.getStaffId()));
  }

  @Test
  public void update() {
      String newStaffName = "Test";
      Staff updateStaff = staffService.update(new Staff.Builder().copy(staff).staffName(newStaffName).build());
      staffs.add(updateStaff);
      Assert.assertEquals(updateStaff, staffService.read(updateStaff.getStaffId()));
  }

  @Test
  public void delete() {
      staffs.addAll(staffService.getAll());
      Staff deleteStaff = staffService.create(StaffFactory.buildStaff(345, "August", "April", "200000", "Claremont"));
      staffs.add(deleteStaff);
      staffs.remove(deleteStaff);
      staffService.delete(deleteStaff.getStaffId());
      Assert.assertEquals(staffs.size(), staffService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Staff> staffSet = staffService.getAll();
      Assert.assertEquals(staffSet.size(), staffService.getAll().size());
  }
}
//"345", "August", "April", "200000", "Claremont"
