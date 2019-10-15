package com.CarRental.service.impl;

import com.CarRental.domain.Profit;
import com.CarRental.factories.ProfitFactory;
import com.CarRental.service.ProfitService;
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
public class ProfitServiceImplTest {
  @Autowired
  @Qualifier("ProfitServiceImpl")
  private ProfitService profitService;
  private Profit profit;
  private Set<Profit> profits = new HashSet<>();

  @Before
  public void setUp() {
      profit = profitService.create(ProfitFactory.buildProfit(789, "100000", "120000"));
      profits.add(profit);
  }

  @Test
  public void create() {
      Profit createProfit = profitService.create(ProfitFactory.buildProfit(
              789, "100000", "120000"));
      profits.add(createProfit);
      Assert.assertEquals(createProfit, profitService.read(createProfit.getProfitId()));
  }

  @Test
  public void read() {
      Profit readTestProfit = profitService.create(ProfitFactory.buildProfit(
              789, "100000", "120000"));
      Assert.assertEquals(readTestProfit, profitService.read(readTestProfit.getProfitId()));
  }

  @Test
  public void update() {
      String newActualProfit = "Test";
      Profit updateProfit = profitService.update(new Profit.Builder().copy(profit).profitActual(newActualProfit).build());
      profits.add(updateProfit);
      Assert.assertEquals(updateProfit, profitService.read(updateProfit.getProfitId()));
  }

  @Test
  public void delete() {
      profits.addAll(profitService.getAll());
      Profit deleteProfit = profitService.create(ProfitFactory.buildProfit(789, "100000", "120000"));
      profits.add(deleteProfit);
      profits.remove(deleteProfit);
      profitService.delete(deleteProfit.getProfitId());
      Assert.assertEquals(profits.size(), profitService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Profit> profitSet = profitService.getAll();
      Assert.assertEquals(profitSet.size(), profitService.getAll().size());
  }
}
//"789", "100000", "120000"
