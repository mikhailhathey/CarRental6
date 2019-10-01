package com.CarRental.service.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.factories.RevenueFactory;
import com.CarRental.service.RevenueService;
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
public class RevenueServiceImplTest {
  @Autowired
  @Qualifier("RevenueServiceImpl")
  private RevenueService revenueService;
  private Revenue revenue;
  private Set<Revenue> revenues = new HashSet<>();

  @Before
  public void setUp() {
      revenue = revenueService.create(RevenueFactory.buildRevenue("345", "August", "April", "200000", "Claremont"));
      revenues.add(revenue);
  }

  @Test
  public void create() {
      Revenue createRevenue = revenueService.create(RevenueFactory.buildRevenue(
              "345", "August", "April", "200000", "Claremont"));
      revenues.add(createRevenue);
      Assert.assertEquals(createRevenue, revenueService.read(createRevenue.getRevenueId()));
  }

  @Test
  public void read() {
      Revenue readTestRevenue = revenueService.create(RevenueFactory.buildRevenue(
              "345", "August", "April", "200000", "Claremont"));
      Assert.assertEquals(readTestRevenue, revenueService.read(readTestRevenue.getRevenueId()));
  }

  @Test
  public void update() {
      String newRevenueBranch = "Test";
      Revenue updateRevenue = revenueService.update(new Revenue.Builder().copy(revenue).revenueBranch(newRevenueBranch).build());
      revenues.add(updateRevenue);
      Assert.assertEquals(updateRevenue, revenueService.read(updateRevenue.getRevenueId()));
  }

  @Test
  public void delete() {
      revenues.addAll(revenueService.getAll());
      Revenue deleteRevenue = revenueService.create(RevenueFactory.buildRevenue("345", "August", "April", "200000", "Claremont"));
      revenues.add(deleteRevenue);
      revenues.remove(deleteRevenue);
      revenueService.delete(deleteRevenue.getRevenueId());
      Assert.assertEquals(revenues.size(), revenueService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Revenue> revenueSet = revenueService.getAll();
      Assert.assertEquals(revenueSet.size(), revenueService.getAll().size());
  }
}
//"345", "August", "April", "200000", "Claremont"
