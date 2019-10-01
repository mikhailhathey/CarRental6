package com.CarRental.service.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.factories.InfrastructureFactory;
import com.CarRental.service.InfrastructureService;
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
public class InfrastructureServiceImplTest {
  @Autowired
  @Qualifier("InfrastructureServiceImpl")
  private InfrastructureService infrastructureService;
  private Infrastructure infrastructure;
  private Set<Infrastructure> infrastructures = new HashSet<>();

  @Before
  public void setUp() {
      infrastructure = infrastructureService.create(InfrastructureFactory.buildInfrastructure("789", "Dimension Data", "Network Servers", "50000"));
      infrastructures.add(infrastructure);
  }

  @Test
  public void create() {
      Infrastructure createInfrastructure = infrastructureService.create(InfrastructureFactory.buildInfrastructure(
              "789", "Dimension Data", "Network Servers", "50000"));
      infrastructures.add(createInfrastructure);
      Assert.assertEquals(createInfrastructure, infrastructureService.read(createInfrastructure.getInfrastructureId()));
  }

  @Test
  public void read() {
      Infrastructure readTestInfrastructure = infrastructureService.create(InfrastructureFactory.buildInfrastructure(
              "789", "Dimension Data", "Network Servers", "50000"));
      Assert.assertEquals(readTestInfrastructure, infrastructureService.read(readTestInfrastructure.getInfrastructureId()));
  }

  @Test
  public void update() {
      String newInfrastructureName = "Test";
      Infrastructure updateInfrastructure = infrastructureService.update(new Infrastructure.Builder().copy(infrastructure).infrastructureName(newInfrastructureName).build());
      infrastructures.add(updateInfrastructure);
      Assert.assertEquals(updateInfrastructure, infrastructureService.read(updateInfrastructure.getInfrastructureId()));
  }

  @Test
  public void delete() {
      infrastructures.addAll(infrastructureService.getAll());
      Infrastructure deleteInfrastructure = infrastructureService.create(InfrastructureFactory.buildInfrastructure("789", "Dimension Data", "Network Servers", "50000"));
      infrastructures.add(deleteInfrastructure);
      infrastructures.remove(deleteInfrastructure);
      infrastructureService.delete(deleteInfrastructure.getInfrastructureId());
      Assert.assertEquals(infrastructures.size(), infrastructureService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Infrastructure> infrastructureSet = infrastructureService.getAll();
      Assert.assertEquals(infrastructureSet.size(), infrastructureService.getAll().size());
  }
}
//"789", "Dimension Data", "Network Servers", "50000"
