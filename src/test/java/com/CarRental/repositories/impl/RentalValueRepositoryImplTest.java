package com.CarRental.repositories.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.factories.RentalValueFactory;
import com.CarRental.repositories.RentalValueRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentalValueRepositoryImplTest {

    private RentalValueRepository repository;
    private RentalValue rentalValue;

    private RentalValue getSavedRentalValue() {
        Set<RentalValue> savedRentalValues = this.repository.getAll();
        return savedRentalValues.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RentalValueRepositoryImpl.getRepository();
        this.rentalValue = RentalValueFactory.buildRentalValue("902", "Bus", "4000");
    }

    @Test
    public void a_create() {
        RentalValue created = this.repository.create(this.rentalValue);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.rentalValue);
    }

    @Test
    public void b_read() {
       RentalValue savedRentalValue = getSavedRentalValue();
        System.out.println("In read, rentalValueId = "+ savedRentalValue.getRentalValueId());
        RentalValue read = this.repository.read(savedRentalValue.getRentalValueId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRentalValue, read);
    }

    @Test
    public void e_delete() {
        RentalValue savedRentalValue = getSavedRentalValue();
        this.repository.delete(savedRentalValue.getRentalValueId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test RentalValue Name";
        RentalValue rentalValue = new RentalValue.Builder().copy(getSavedRentalValue()).rentalValueAmount(newname).build();
        System.out.println("In update, about_to_updated = " + rentalValue);
        RentalValue updated = this.repository.update(rentalValue);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getRentalValueAmount());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<RentalValue> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
