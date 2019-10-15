package com.CarRental.service.impl;

import com.CarRental.domain.VehicleSellingPrice;
import com.CarRental.factories.VehicleSellingPriceFactory;
import com.CarRental.service.VehicleSellingPriceService;
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
public class VehicleSellingPriceServiceImplTest {
  @Autowired
  @Qualifier("VehicleSellingPriceServiceImpl")
  private VehicleSellingPriceService vehicleSellingPriceService;
  private VehicleSellingPrice vehicleSellingPrice;
  private Set<VehicleSellingPrice> vehicleSellingPrices = new HashSet<>();

  @Before
  public void setUp() {
      vehicleSellingPrice = vehicleSellingPriceService.create(VehicleSellingPriceFactory.buildVehicleSellingPrice(452, "2016", "180000"));
      vehicleSellingPrices.add(vehicleSellingPrice);
  }

  @Test
  public void create() {
      VehicleSellingPrice createVehicleSellingPrice = vehicleSellingPriceService.create(VehicleSellingPriceFactory.buildVehicleSellingPrice(
              452, "2016", "180000"));
      vehicleSellingPrices.add(createVehicleSellingPrice);
      Assert.assertEquals(createVehicleSellingPrice, vehicleSellingPriceService.read(createVehicleSellingPrice.getVehicleSellingPriceId()));
  }

  @Test
  public void read() {
      VehicleSellingPrice readTestVehicleSellingPrice = vehicleSellingPriceService.create(VehicleSellingPriceFactory.buildVehicleSellingPrice(
              452, "2016", "180000"));
      Assert.assertEquals(readTestVehicleSellingPrice, vehicleSellingPriceService.read(readTestVehicleSellingPrice.getVehicleSellingPriceId()));
  }

  @Test
  public void update() {
      String newVehicleYearModel = "Test";
      VehicleSellingPrice updateVehicleSellingPrice = vehicleSellingPriceService.update(new VehicleSellingPrice.Builder().copy(vehicleSellingPrice).vehicleYearModel(newVehicleYearModel).build());
      vehicleSellingPrices.add(updateVehicleSellingPrice);
      Assert.assertEquals(updateVehicleSellingPrice, vehicleSellingPriceService.read(updateVehicleSellingPrice.getVehicleSellingPriceId()));
  }

  @Test
  public void delete() {
      vehicleSellingPrices.addAll(vehicleSellingPriceService.getAll());
      VehicleSellingPrice deleteVehicleSellingPrice = vehicleSellingPriceService.create(VehicleSellingPriceFactory.buildVehicleSellingPrice(452, "2016", "180000"));
      vehicleSellingPrices.add(deleteVehicleSellingPrice);
      vehicleSellingPrices.remove(deleteVehicleSellingPrice);
      vehicleSellingPriceService.delete(deleteVehicleSellingPrice.getVehicleSellingPriceId());
      Assert.assertEquals(vehicleSellingPrices.size(), vehicleSellingPriceService.getAll().size());
  }

  @Test
  public void getAll() {
      List<VehicleSellingPrice> vehicleSellingPriceSet = vehicleSellingPriceService.getAll();
      Assert.assertEquals(vehicleSellingPriceSet.size(), vehicleSellingPriceService.getAll().size());
  }
}
//"452", "2016", "180000"
