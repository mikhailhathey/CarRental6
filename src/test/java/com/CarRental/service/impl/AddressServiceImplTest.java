package com.CarRental.service.impl;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import com.CarRental.repositories.impl.AddressRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImplTest {

    private AddressRepositoryImpl repository;
    private Address address;

    private Address getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AddressRepositoryImpl.getRepository();
        this.address = AddressFactory.buildAddress("123", "81", "Main Road", "Kenwyn", "7780", "Cape Town");
    }

    @Test
    public void a_create() {
        Address created = this.repository.create(this.address);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.address);
    }

    @Test
    public void c_update() {
        String newAddressName = "Application Development Theory 3";
        Address updated = new Address.Builder().copy(getSaved()).addressId(newAddressName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAddressName, updated.getAddressId());
    }

    @Test
    public void e_delete() {
        Address saved = getSaved();
        this.repository.delete(saved.getAddressId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Address saved = getSaved();
        Address read = this.repository.read(saved.getAddressId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Address> address = this.repository.getAll();
        System.out.println("In getall, all = " + address);
    }
}
