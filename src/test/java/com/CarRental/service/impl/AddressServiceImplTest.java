package com.CarRental.service.impl;

import com.CarRental.domain.Address;
import com.CarRental.factories.AddressFactory;
import com.CarRental.service.AddressService;
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
public class AddressServiceImplTest {
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService addressService;
    private Address address;
    private Set<Address> addresses = new HashSet<>();

    @Before
    public void setUp() {
        address = addressService.create(AddressFactory.buildAddress("246", "8", "Stock",
                "Lansdowne", "7764", "Cape Town"));
        addresses.add(address);
    }

    @Test
    public void create() {
        Address createAddress = addressService.create(AddressFactory.buildAddress(
                "357", "24", "Brockhurst",
                "Constantia", "7720", "Cape Town"));
        addresses.add(createAddress);
        Assert.assertEquals(createAddress, addressService.read(createAddress.getAddressId()));
    }

    @Test
    public void read() {
        Address readTestAddress = addressService.create(AddressFactory.buildAddress(
                "786", "99", "Main",
                "Laudium", "7786", "Pretoria"));
        Assert.assertEquals(readTestAddress, addressService.read(readTestAddress.getAddressId()));
    }

    @Test
    public void update() {
        String newStreetName = "Test";
        Address updateAddress = addressService.update(new Address.Builder().copy(address).streetName(newStreetName).build());
        addresses.add(updateAddress);
        Assert.assertEquals(updateAddress, addressService.read(updateAddress.getAddressId()));
    }

    @Test
    public void delete() {
        addresses.addAll(addressService.getAll());
        Address deleteAddress = addressService.create(AddressFactory.buildAddress("468", "68", "Forest",
                "Newlands", "7804", "Cape Town"));
        addresses.add(deleteAddress);
        addresses.remove(deleteAddress);
        addressService.delete(deleteAddress.getAddressId());
        Assert.assertEquals(addresses.size(), addressService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Address> addressSet = addressService.getAll();
        Assert.assertEquals(addressSet.size(), addressService.getAll().size());
    }
}
