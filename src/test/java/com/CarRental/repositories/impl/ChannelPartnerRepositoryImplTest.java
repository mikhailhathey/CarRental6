package com.CarRental.repositories.impl;

import com.CarRental.domain.ChannelPartner;
import com.CarRental.factories.ChannelPartnerFactory;
import com.CarRental.repositories.ChannelPartnerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChannelPartnerRepositoryImplTest {

    private ChannelPartnerRepository repository;
    private ChannelPartner channelPartner;

    private ChannelPartner getSavedChannelPartner() {
        Set<ChannelPartner> savedChannelPartners = this.repository.getAll();
        return savedChannelPartners.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.channelPartner);
    }

    @Test
    public void b_read() {
       ChannelPartner savedChannelPartner = getSavedChannelPartner();
        System.out.println("In read, channelPartnerId = "+ savedChannelPartner.getChannelPartnerId());
        ChannelPartner read = this.repository.read(savedChannelPartner.getChannelPartnerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedChannelPartner, read);
    }

    @Test
    public void e_delete() {
        ChannelPartner savedChannelPartner = getSavedChannelPartner();
        this.repository.delete(savedChannelPartner.getChannelPartnerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test ChannelPartner Name";
        ChannelPartner channelPartner = new ChannelPartner.Builder().copy(getSavedChannelPartner()).channelPartnerName(newname).build();
        System.out.println("In update, about_to_updated = " + channelPartner);
        ChannelPartner updated = this.repository.update(channelPartner);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getChannelPartnerName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<ChannelPartner> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
