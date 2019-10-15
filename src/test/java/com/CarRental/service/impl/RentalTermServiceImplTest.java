package com.CarRental.service.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.factories.RentalTermFactory;
import com.CarRental.service.RentalTermService;
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
public class RentalTermServiceImplTest {
  @Autowired
  @Qualifier("RentalTermServiceImpl")
  private RentalTermService rentalTermService;
  private RentalTerm rentalTerm;
  private Set<RentalTerm> rentalTerms = new HashSet<>();

  @Before
  public void setUp() {
      rentalTerm = rentalTermService.create(RentalTermFactory.buildRentalTerm(324, "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD"));
      rentalTerms.add(rentalTerm);
  }

  @Test
  public void create() {
      RentalTerm createRentalTerm = rentalTermService.create(RentalTermFactory.buildRentalTerm(
              324, "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD"));
      rentalTerms.add(createRentalTerm);
      Assert.assertEquals(createRentalTerm, rentalTermService.read(createRentalTerm.getRentalTermId()));
  }

  @Test
  public void read() {
      RentalTerm readTestRentalTerm = rentalTermService.create(RentalTermFactory.buildRentalTerm(
              324, "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD"));
      Assert.assertEquals(readTestRentalTerm, rentalTermService.read(readTestRentalTerm.getRentalTermId()));
  }

  @Test
  public void update() {
      String newRentalTermContact = "Test";
      RentalTerm updateRentalTerm = rentalTermService.update(new RentalTerm.Builder().copy(rentalTerm).rentalTermContact(newRentalTermContact).build());
      rentalTerms.add(updateRentalTerm);
      Assert.assertEquals(updateRentalTerm, rentalTermService.read(updateRentalTerm.getRentalTermId()));
  }

  @Test
  public void delete() {
      rentalTerms.addAll(rentalTermService.getAll());
      RentalTerm deleteRentalTerm = rentalTermService.create(RentalTermFactory.buildRentalTerm(324, "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD"));
      rentalTerms.add(deleteRentalTerm);
      rentalTerms.remove(deleteRentalTerm);
      rentalTermService.delete(deleteRentalTerm.getRentalTermId());
      Assert.assertEquals(rentalTerms.size(), rentalTermService.getAll().size());
  }

  @Test
  public void getAll() {
      List<RentalTerm> rentalTermSet = rentalTermService.getAll();
      Assert.assertEquals(rentalTermSet.size(), rentalTermService.getAll().size());
  }
}
//"324", "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD"
