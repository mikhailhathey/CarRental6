package com.CarRental.service.impl;

import com.CarRental.domain.Admin;
import com.CarRental.factories.AdminFactory;
import com.CarRental.service.AdminService;
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
public class AdminServiceImplTest {
  @Autowired
  @Qualifier("AdminServiceImpl")
  private AdminService adminService;
  private Admin admin;
  private Set<Admin> admins = new HashSet<>();

  @Before
  public void setUp() {
      admin = adminService.create(AdminFactory.buildAdmin(123, "AdminUser", "Password123"));
      admins.add(admin);
  }

  @Test
  public void create() {
      Admin createAdmin = adminService.create(AdminFactory.buildAdmin(456, "TestUser", "Password456"));
      admins.add(createAdmin);
      Assert.assertEquals(createAdmin, adminService.read(createAdmin.getAdminId()));
  }

  @Test
  public void read() {
      Admin readTestAdmin = adminService.create(AdminFactory.buildAdmin(
              789, "ReadUser", "Password789"));
      Assert.assertEquals(readTestAdmin, adminService.read(readTestAdmin.getAdminId()));
  }

  @Test
  public void update() {
      String newAdminName = "Test";
      Admin updateAdmin = adminService.update(new Admin.Builder().copy(admin).adminName(newAdminName).build());
      admins.add(updateAdmin);
      Assert.assertEquals(updateAdmin, adminService.read(updateAdmin.getAdminId()));
  }

  @Test
  public void delete() {
      admins.addAll(adminService.getAll());
      Admin deleteAdmin = adminService.create(AdminFactory.buildAdmin(567, "GetUser", "Password567"));
      admins.add(deleteAdmin);
      admins.remove(deleteAdmin);
      adminService.delete(deleteAdmin.getAdminId());
      Assert.assertEquals(admins.size(), adminService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Admin> adminSet = adminService.getAll();
      Assert.assertEquals(adminSet.size(), adminService.getAll().size());
  }
}
