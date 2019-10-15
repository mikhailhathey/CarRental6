package com.CarRental.service.impl;

import com.CarRental.domain.Claims;
import com.CarRental.factories.ClaimsFactory;
import com.CarRental.service.ClaimsService;
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
public class ClaimsServiceImplTest {
  @Autowired
  @Qualifier("ClaimsServiceImpl")
  private ClaimsService claimsService;
  private Claims claims;
  private Set<Claims> claimss = new HashSet<>();

  @Before
  public void setUp() {
      claims = claimsService.create(ClaimsFactory.buildClaims(1234, "Discovery", "12000", "Stolen"));
      claimss.add(claims);
  }

  @Test
  public void create() {
      Claims createClaims = claimsService.create(ClaimsFactory.buildClaims(
              1234, "Discovery", "12000", "Stolen"));
      claimss.add(createClaims);
      Assert.assertEquals(createClaims, claimsService.read(createClaims.getClaimsId()));
  }

  @Test
  public void read() {
      Claims readTestClaims = claimsService.create(ClaimsFactory.buildClaims(
              1234, "Discovery", "12000", "Stolen"));
      Assert.assertEquals(readTestClaims, claimsService.read(readTestClaims.getClaimsId()));
  }

  @Test
  public void update() {
      String newClaimReason = "Test";
      Claims updateClaims = claimsService.update(new Claims.Builder().copy(claims).claimReason(newClaimReason).build());
      claimss.add(updateClaims);
      Assert.assertEquals(updateClaims, claimsService.read(updateClaims.getClaimsId()));
  }

  @Test
  public void delete() {
      claimss.addAll(claimsService.getAll());
      Claims deleteClaims = claimsService.create(ClaimsFactory.buildClaims(1234, "Discovery", "12000", "Stolen"));
      claimss.add(deleteClaims);
      claimss.remove(deleteClaims);
      claimsService.delete(deleteClaims.getClaimsId());
      Assert.assertEquals(claimss.size(), claimsService.getAll().size());
  }

  @Test
  public void getAll() {
      List<Claims> claimsSet = claimsService.getAll();
      Assert.assertEquals(claimsSet.size(), claimsService.getAll().size());
  }
}
//"1234", "Discovery", "12000", "Stolen"
