package com.CarRental.service.impl;

import com.CarRental.domain.RentalValue;
import com.CarRental.factories.RentalValueFactory;
import com.CarRental.repositories.impl.RentalValueRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentalValueServiceImplTest {

    private RentalValueRepositoryImpl repository;
    private RentalValue rentalValue;

    private RentalValue getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.rentalValue);
    }

    @Test
    public void c_update() {
        String newRentalValueName = "Application Development Theory 3";
        RentalValue updated = new RentalValue.Builder().copy(getSaved()).rentalValueId(newRentalValueName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newRentalValueName, updated.getRentalValueId());
    }

    @Test
    public void e_delete() {
        RentalValue saved = getSaved();
        this.repository.delete(saved.getRentalValueId());
        d_getAll();
    }

    @Test
    public void b_read() {
        RentalValue saved = getSaved();
        RentalValue read = this.repository.read(saved.getRentalValueId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<RentalValue> rentalValues = this.repository.getAll();
        System.out.println("In getall, all = " + rentalValues);
    }
}
