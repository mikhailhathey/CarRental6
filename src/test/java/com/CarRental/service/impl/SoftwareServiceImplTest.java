package com.CarRental.service.impl;

import com.CarRental.domain.Software;
import com.CarRental.factories.SoftwareFactory;
import com.CarRental.service.SoftwareService;
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
public class SoftwareServiceImplTest {
  @Autowired
  @Qualifier("SoftwareServiceImpl")
  private SoftwareService softwareService;
  private Software software;
  private Set<Software> softwares = new HashSet<>();

  @Before
  public void setUp() {
      software = softwareService.create(SoftwareFactory.buildSoftware(769, "Pascal", "2.6", "3000"));
      softwares.add(software);
  }

  @Test
  public void create() {
      Software createSoftware = softwareService.create(SoftwareFactory.buildSoftware(
              769, "Pascal", "2.6", "3000"));
      softwares.add(createSoftware);
      Assert.assertEquals(createSoftware, softwareService.read(createSoftware.getSoftwareId()));
  }

  @Test
  public void read() {
      Software readTestSoftware = softwareService.create(SoftwareFactory.buildSoftware(
              769, "Pascal", "2.6", "3000"));
      Assert.assertEquals(readTestSoftware, softwareService.read(readTestSoftware.getSoftwareId()));
  }

  @Test
  public void update() {
      String newSoftwareName = "Test";
      Software updateSoftware = softwareService.update(new Software.Builder().copy(software).softwareName(newSoftwareName).build());
      softwares.add(updateSoftware);
      Assert.assertEquals(updateSoftware, softwareService.read(updateSoftware.getSoftwareId()));
  }

  @Test
  public void delete() {
      softwares.addAll(softwareService.getAll());
      Software deleteSoftware = softwareService.create(SoftwareFactory.buildSoftware(769, "Pascal", "2.6", "3000"));
      softwares.add(deleteSoftware);
      softwares.remove(deleteSoftware);
      softwareService.delete(deleteSoftware.getSoftwareId());
      Assert.assertEquals(softwares.size(), softwareService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Software> softwareSet = softwareService.getAll();
      Assert.assertEquals(softwareSet.size(), softwareService.getAll().size());
  }
}
//"769", "Pascal", "2.6", "3000"
