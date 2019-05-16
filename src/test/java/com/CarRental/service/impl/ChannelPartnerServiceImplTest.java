package com.CarRental.service.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.factories.ChannelPartnerFactory;
import com.CarRental.repositories.impl.ChannelPartnerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChannelPartnerServiceImplTest {

    private ChannelPartnerRepositoryImpl repository;
    private ChannelPartner channelPartner;

    private ChannelPartner getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ChannelPartnerRepositoryImpl.getRepository();
        this.channelPartner = ChannelPartnerFactory.buildChannelPartner("1234", "Microsoft", "John", "john@microsoft.com");
    }

    @Test
    public void a_create() {
        ChannelPartner created = this.repository.create(this.channelPartner);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.channelPartner);
    }

    @Test
    public void c_update() {
        String newChannelPartnerName = "Application Development Theory 3";
        ChannelPartner updated = new ChannelPartner.Builder().copy(getSaved()).channelPartnerId(newChannelPartnerName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newChannelPartnerName, updated.getChannelPartnerId());
    }

    @Test
    public void e_delete() {
        ChannelPartner saved = getSaved();
        this.repository.delete(saved.getChannelPartnerId());
        d_getAll();
    }

    @Test
    public void b_read() {
        ChannelPartner saved = getSaved();
        ChannelPartner read = this.repository.read(saved.getChannelPartnerId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<ChannelPartner> channelPartners = this.repository.getAll();
        System.out.println("In getall, all = " + channelPartners);
    }
}
