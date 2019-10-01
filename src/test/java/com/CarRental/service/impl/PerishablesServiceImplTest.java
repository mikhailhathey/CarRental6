package com.CarRental.service.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.factories.PerishablesFactory;
import com.CarRental.service.PerishablesService;
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
public class PerishablesServiceImplTest {
  @Autowired
  @Qualifier("PerishablesServiceImpl")
  private PerishablesService perishablesService;
  private Perishables perishables;
  private Set<Perishables> perishabless = new HashSet<>();

  @Before
  public void setUp() {
      perishables = perishablesService.create(PerishablesFactory.buildPerishables("567", "Bread", "12/05/2019", "5"));
      perishabless.add(perishables);
  }

  @Test
  public void create() {
      Perishables createPerishables = perishablesService.create(PerishablesFactory.buildPerishables(
              "567", "Bread", "12/05/2019", "5"));
      perishabless.add(createPerishables);
      Assert.assertEquals(createPerishables, perishablesService.read(createPerishables.getPerishablesId()));
  }

  @Test
  public void read() {
      Perishables readTestPerishables = perishablesService.create(PerishablesFactory.buildPerishables(
              "567", "Bread", "12/05/2019", "5"));
      Assert.assertEquals(readTestPerishables, perishablesService.read(readTestPerishables.getPerishablesId()));
  }

  @Test
  public void update() {
      String newPerishableName = "Test";
      Perishables updatePerishables = perishablesService.update(new Perishables.Builder().copy(perishables).perishableName(newPerishableName).build());
      perishabless.add(updatePerishables);
      Assert.assertEquals(updatePerishables, perishablesService.read(updatePerishables.getPerishablesId()));
  }

  @Test
  public void delete() {
      perishabless.addAll(perishablesService.getAll());
      Perishables deletePerishables = perishablesService.create(PerishablesFactory.buildPerishables("567", "Bread", "12/05/2019", "5"));
      perishabless.add(deletePerishables);
      perishabless.remove(deletePerishables);
      perishablesService.delete(deletePerishables.getPerishablesId());
      Assert.assertEquals(perishabless.size(), perishablesService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Perishables> perishablesSet = perishablesService.getAll();
      Assert.assertEquals(perishablesSet.size(), perishablesService.getAll().size());
  }
}
//"567", "Bread", "12/05/2019", "5"
