package com.CarRental.service.impl;

import com.CarRental.domain.VehiclePurchasePrice;
import com.CarRental.factories.VehiclePurchasePriceFactory;
import com.CarRental.service.VehiclePurchasePriceService;
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
public class VehiclePurchasePriceServiceImplTest {
  @Autowired
  @Qualifier("VehiclePurchasePriceServiceImpl")
  private VehiclePurchasePriceService vehiclePurchasePriceService;
  private VehiclePurchasePrice vehiclePurchasePrice;
  private Set<VehiclePurchasePrice> vehiclePurchasePrices = new HashSet<>();

  @Before
  public void setUp() {
      vehiclePurchasePrice = vehiclePurchasePriceService.create(VehiclePurchasePriceFactory.buildVehiclePurchasePrice(452, "2016", "160000"));
      vehiclePurchasePrices.add(vehiclePurchasePrice);
  }

  @Test
  public void create() {
      VehiclePurchasePrice createVehiclePurchasePrice = vehiclePurchasePriceService.create(VehiclePurchasePriceFactory.buildVehiclePurchasePrice(
              452, "2016", "160000"));
      vehiclePurchasePrices.add(createVehiclePurchasePrice);
      Assert.assertEquals(createVehiclePurchasePrice, vehiclePurchasePriceService.read(createVehiclePurchasePrice.getVehiclePurchasePriceId()));
  }

  @Test
  public void read() {
      VehiclePurchasePrice readTestVehiclePurchasePrice = vehiclePurchasePriceService.create(VehiclePurchasePriceFactory.buildVehiclePurchasePrice(
              452, "2016", "160000"));
      Assert.assertEquals(readTestVehiclePurchasePrice, vehiclePurchasePriceService.read(readTestVehiclePurchasePrice.getVehiclePurchasePriceId()));
  }

  @Test
  public void update() {
      String newVehicleYearModel = "Test";
      VehiclePurchasePrice updateVehiclePurchasePrice = vehiclePurchasePriceService.update(new VehiclePurchasePrice.Builder().copy(vehiclePurchasePrice).vehicleYearModel(newVehicleYearModel).build());
      vehiclePurchasePrices.add(updateVehiclePurchasePrice);
      Assert.assertEquals(updateVehiclePurchasePrice, vehiclePurchasePriceService.read(updateVehiclePurchasePrice.getVehiclePurchasePriceId()));
  }

  @Test
  public void delete() {
      vehiclePurchasePrices.addAll(vehiclePurchasePriceService.getAll());
      VehiclePurchasePrice deleteVehiclePurchasePrice = vehiclePurchasePriceService.create(VehiclePurchasePriceFactory.buildVehiclePurchasePrice(452, "2016", "160000"));
      vehiclePurchasePrices.add(deleteVehiclePurchasePrice);
      vehiclePurchasePrices.remove(deleteVehiclePurchasePrice);
      vehiclePurchasePriceService.delete(deleteVehiclePurchasePrice.getVehiclePurchasePriceId());
      Assert.assertEquals(vehiclePurchasePrices.size(), vehiclePurchasePriceService.getAll().size());
  }

  @Test
  public void getAll() {
      List<VehiclePurchasePrice> vehiclePurchasePriceSet = vehiclePurchasePriceService.getAll();
      Assert.assertEquals(vehiclePurchasePriceSet.size(), vehiclePurchasePriceService.getAll().size());
  }
}
//"452", "2016", "160000"
