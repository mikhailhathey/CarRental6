package com.CarRental.service.impl;

import com.CarRental.domain.Hardware;
import com.CarRental.factories.HardwareFactory;
import com.CarRental.service.HardwareService;
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
public class HardwareServiceImplTest {
  @Autowired
  @Qualifier("HardwareServiceImpl")
  private HardwareService hardwareService;
  private Hardware hardware;
  private Set<Hardware> hardwares = new HashSet<>();

  @Before
  public void setUp() {
      hardware = hardwareService.create(HardwareFactory.buildHardware("456", "Laptop", "4500"));
      hardwares.add(hardware);
  }

  @Test
  public void create() {
      Hardware createHardware = hardwareService.create(HardwareFactory.buildHardware(
              "456", "Laptop", "4500"));
      hardwares.add(createHardware);
      Assert.assertEquals(createHardware, hardwareService.read(createHardware.getHardwareId()));
  }

  @Test
  public void read() {
      Hardware readTestHardware = hardwareService.create(HardwareFactory.buildHardware(
              "456", "Laptop", "4500"));
      Assert.assertEquals(readTestHardware, hardwareService.read(readTestHardware.getHardwareId()));
  }

  @Test
  public void update() {
      String newHardwareName = "Test";
      Hardware updateHardware = hardwareService.update(new Hardware.Builder().copy(hardware).hardwareName(newHardwareName).build());
      hardwares.add(updateHardware);
      Assert.assertEquals(updateHardware, hardwareService.read(updateHardware.getHardwareId()));
  }

  @Test
  public void delete() {
      hardwares.addAll(hardwareService.getAll());
      Hardware deleteHardware = hardwareService.create(HardwareFactory.buildHardware("456", "Laptop", "4500"));
      hardwares.add(deleteHardware);
      hardwares.remove(deleteHardware);
      hardwareService.delete(deleteHardware.getHardwareId());
      Assert.assertEquals(hardwares.size(), hardwareService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Hardware> hardwareSet = hardwareService.getAll();
      Assert.assertEquals(hardwareSet.size(), hardwareService.getAll().size());
  }
}
//"456", "Laptop", "4500"
