package com.CarRental.repositories.impl;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import com.CarRental.repositories.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryImplTest {

    private AddressRepository repository;
    private Address address;

    private Address getSavedAddress() {
        Set<Address> savedAddresss = this.repository.getAll();
        return savedAddresss.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.address);
    }

    @Test
    public void b_read() {
       Address savedAddress = getSavedAddress();
        System.out.println("In read, addressId = "+ savedAddress.getAddressId());
        Address read = this.repository.read(savedAddress.getAddressId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAddress, read);
    }

    @Test
    public void e_delete() {
        Address savedAddress = getSavedAddress();
        this.repository.delete(savedAddress.getAddressId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Address Name";
        Address address = new Address.Builder().copy(getSavedAddress()).streetName(newname).build();
        System.out.println("In update, about_to_updated = " + address);
        Address updated = this.repository.update(address);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getStreetName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Address> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
