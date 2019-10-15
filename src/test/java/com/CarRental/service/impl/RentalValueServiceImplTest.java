package com.CarRental.service.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.factories.RentalValueFactory;
import com.CarRental.service.RentalValueService;
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
public class RentalValueServiceImplTest {
  @Autowired
  @Qualifier("RentalValueServiceImpl")
  private RentalValueService rentalValueService;
  private RentalValue rentalValue;
  private Set<RentalValue> rentalValues = new HashSet<>();

  @Before
  public void setUp() {
      rentalValue = rentalValueService.create(RentalValueFactory.buildRentalValue(902, "Bus", "4000"));
      rentalValues.add(rentalValue);
  }

  @Test
  public void create() {
      RentalValue createRentalValue = rentalValueService.create(RentalValueFactory.buildRentalValue(
              902, "Bus", "4000"));
      rentalValues.add(createRentalValue);
      Assert.assertEquals(createRentalValue, rentalValueService.read(createRentalValue.getRentalValueId()));
  }

  @Test
  public void read() {
      RentalValue readTestRentalValue = rentalValueService.create(RentalValueFactory.buildRentalValue(
              902, "Bus", "4000"));
      Assert.assertEquals(readTestRentalValue, rentalValueService.read(readTestRentalValue.getRentalValueId()));
  }

  @Test
  public void update() {
      String newRentalValueAmt = "Test";
      RentalValue updateRentalValue = rentalValueService.update(new RentalValue.Builder().copy(rentalValue).rentalValueAmount(newRentalValueAmt).build());
      rentalValues.add(updateRentalValue);
      Assert.assertEquals(updateRentalValue, rentalValueService.read(updateRentalValue.getRentalValueId()));
  }

  @Test
  public void delete() {
      rentalValues.addAll(rentalValueService.getAll());
      RentalValue deleteRentalValue = rentalValueService.create(RentalValueFactory.buildRentalValue(902, "Bus", "4000"));
      rentalValues.add(deleteRentalValue);
      rentalValues.remove(deleteRentalValue);
      rentalValueService.delete(deleteRentalValue.getRentalValueId());
      Assert.assertEquals(rentalValues.size(), rentalValueService.getAll().size());
  }

  @Test
  public void getAll() {
      List<RentalValue> rentalValueSet = rentalValueService.getAll();
      Assert.assertEquals(rentalValueSet.size(), rentalValueService.getAll().size());
  }
}
//"902", "Bus", "4000"
