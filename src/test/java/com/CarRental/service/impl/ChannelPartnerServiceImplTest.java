package com.CarRental.service.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.factories.ChannelPartnerFactory;
import com.CarRental.service.ChannelPartnerService;
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
public class ChannelPartnerServiceImplTest {
  @Autowired
  @Qualifier("ChannelPartnerServiceImpl")
  private ChannelPartnerService channelPartnerService;
  private ChannelPartner channelPartner;
  private Set<ChannelPartner> channelPartners = new HashSet<>();

  @Before
  public void setUp() {
      channelPartner = channelPartnerService.create(ChannelPartnerFactory.buildChannelPartner(1234, "Microsoft", "John", "john@microsoft.com"));
      channelPartners.add(channelPartner);
  }

  @Test
  public void create() {
      ChannelPartner createChannelPartner = channelPartnerService.create(ChannelPartnerFactory.buildChannelPartner(
              1234, "Microsoft", "John", "john@microsoft.com"));
      channelPartners.add(createChannelPartner);
      Assert.assertEquals(createChannelPartner, channelPartnerService.read(createChannelPartner.getChannelPartnerId()));
  }

  @Test
  public void read() {
      ChannelPartner readTestChannelPartner = channelPartnerService.create(ChannelPartnerFactory.buildChannelPartner(
              1234, "Microsoft", "John", "john@microsoft.com"));
      Assert.assertEquals(readTestChannelPartner, channelPartnerService.read(readTestChannelPartner.getChannelPartnerId()));
  }

  @Test
  public void update() {
      String newChannelPartnerName = "Test";
      ChannelPartner updateChannelPartner = channelPartnerService.update(new ChannelPartner.Builder().copy(channelPartner).channelPartnerName(newChannelPartnerName).build());
      channelPartners.add(updateChannelPartner);
      Assert.assertEquals(updateChannelPartner, channelPartnerService.read(updateChannelPartner.getChannelPartnerId()));
  }

  @Test
  public void delete() {
      channelPartners.addAll(channelPartnerService.getAll());
      ChannelPartner deleteChannelPartner = channelPartnerService.create(ChannelPartnerFactory.buildChannelPartner(1234, "Microsoft", "John", "john@microsoft.com"));
      channelPartners.add(deleteChannelPartner);
      channelPartners.remove(deleteChannelPartner);
      channelPartnerService.delete(deleteChannelPartner.getChannelPartnerId());
      Assert.assertEquals(channelPartners.size(), channelPartnerService.getAll().size());
  }

  @Test
  public void getAll() {
      List<ChannelPartner> channelPartnerSet = channelPartnerService.getAll();
      Assert.assertEquals(channelPartnerSet.size(), channelPartnerService.getAll().size());
  }
}
//"1234", "Microsoft", "John", "john@microsoft.com"
