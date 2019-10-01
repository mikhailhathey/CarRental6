package com.CarRental.service.impl;

import com.CarRental.domain.FleetManager;
import com.CarRental.factories.FleetManagerFactory;
import com.CarRental.service.FleetManagerService;
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
public class FleetManagerServiceImplTest {
  @Autowired
  @Qualifier("FleetManagerServiceImpl")
  private FleetManagerService fleetManagerService;
  private FleetManager fleetManager;
  private Set<FleetManager> fleetManagers = new HashSet<>();

  @Before
  public void setUp() {
      fleetManager = fleetManagerService.create(FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth"));
      fleetManagers.add(fleetManager);
  }

  @Test
  public void create() {
      FleetManager createFleetManager = fleetManagerService.create(FleetManagerFactory.buildFleetManager(
              "123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth"));
      fleetManagers.add(createFleetManager);
      Assert.assertEquals(createFleetManager, fleetManagerService.read(createFleetManager.getFleetManagerId()));
  }

  @Test
  public void read() {
      FleetManager readTestFleetManager = fleetManagerService.create(FleetManagerFactory.buildFleetManager(
              "123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth"));
      Assert.assertEquals(readTestFleetManager, fleetManagerService.read(readTestFleetManager.getFleetManagerId()));
  }

  @Test
  public void update() {
      String newFleetManagerContactName = "Test";
      FleetManager updateFleetManager = fleetManagerService.update(new FleetManager.Builder().copy(fleetManager).fleetManagerContact(newFleetManagerContactName).build());
      fleetManagers.add(updateFleetManager);
      Assert.assertEquals(updateFleetManager, fleetManagerService.read(updateFleetManager.getFleetManagerId()));
  }

  @Test
  public void delete() {
      fleetManagers.addAll(fleetManagerService.getAll());
      FleetManager deleteFleetManager = fleetManagerService.create(FleetManagerFactory.buildFleetManager("123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth"));
      fleetManagers.add(deleteFleetManager);
      fleetManagers.remove(deleteFleetManager);
      fleetManagerService.delete(deleteFleetManager.getFleetManagerId());
      Assert.assertEquals(fleetManagers.size(), fleetManagerService.getAll().size());
  }

  @Test
  public void getAll() {
      List<FleetManager> fleetManagerSet = fleetManagerService.getAll();
      Assert.assertEquals(fleetManagerSet.size(), fleetManagerService.getAll().size());
  }
}
//"123456", "400", "Vans", "20", "JohnnyTest", "Kenilworth"
