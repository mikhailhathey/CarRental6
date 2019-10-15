package com.CarRental.service.impl;

import com.CarRental.domain.Supplier;
import com.CarRental.factories.SupplierFactory;
import com.CarRental.service.SupplierService;
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
public class SupplierServiceImplTest {
  @Autowired
  @Qualifier("SupplierServiceImpl")
  private SupplierService supplierService;
  private Supplier supplier;
  private Set<Supplier> suppliers = new HashSet<>();

  @Before
  public void setUp() {
      supplier = supplierService.create(SupplierFactory.buildSupplier(453, "Makro", "Johan", "johan@makro.com"));
      suppliers.add(supplier);
  }

  @Test
  public void create() {
      Supplier createSupplier = supplierService.create(SupplierFactory.buildSupplier(453, "Makro", "Johan", "johan@makro.com"));
      suppliers.add(createSupplier);
      Assert.assertEquals(createSupplier, supplierService.read(createSupplier.getSupplierId()));
  }

  @Test
  public void read() {
      Supplier readTestSupplier = supplierService.create(SupplierFactory.buildSupplier(
              453, "Makro", "Johan", "johan@makro.com"));
      Assert.assertEquals(readTestSupplier, supplierService.read(readTestSupplier.getSupplierId()));
  }

  @Test
  public void update() {
      String newSupplierName = "Test";
      Supplier updateSupplier = supplierService.update(new Supplier.Builder().copy(supplier).supplierName(newSupplierName).build());
      suppliers.add(updateSupplier);
      Assert.assertEquals(updateSupplier, supplierService.read(updateSupplier.getSupplierId()));
  }

  @Test
  public void delete() {
      suppliers.addAll(supplierService.getAll());
      Supplier deleteSupplier = supplierService.create(SupplierFactory.buildSupplier(453, "Makro", "Johan", "johan@makro.com"));
      suppliers.add(deleteSupplier);
      suppliers.remove(deleteSupplier);
      supplierService.delete(deleteSupplier.getSupplierId());
      Assert.assertEquals(suppliers.size(), supplierService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Supplier> supplierSet = supplierService.getAll();
      Assert.assertEquals(supplierSet.size(), supplierService.getAll().size());
  }
}
//"453", "Makro", "Johan", "johan@makro.com"
