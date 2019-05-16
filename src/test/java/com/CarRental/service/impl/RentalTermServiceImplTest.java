package com.CarRental.service.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.factories.RentalTermFactory;
import com.CarRental.repositories.impl.RentalTermRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentalTermServiceImplTest {

    private RentalTermRepositoryImpl repository;
    private RentalTerm rentalTerm;

    private RentalTerm getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RentalTermRepositoryImpl.getRepository();
        this.rentalTerm = RentalTermFactory.buildRentalTerm("324", "12", "Passenger", "20", "JohnnyTest", "Cape Town CBD");
    }

    @Test
    public void a_create() {
        RentalTerm created = this.repository.create(this.rentalTerm);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.rentalTerm);
    }

    @Test
    public void c_update() {
        String newRentalTermName = "Application Development Theory 3";
        RentalTerm updated = new RentalTerm.Builder().copy(getSaved()).rentalTermId(newRentalTermName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newRentalTermName, updated.getRentalTermId());
    }

    @Test
    public void e_delete() {
        RentalTerm saved = getSaved();
        this.repository.delete(saved.getRentalTermId());
        d_getAll();
    }

    @Test
    public void b_read() {
        RentalTerm saved = getSaved();
        RentalTerm read = this.repository.read(saved.getRentalTermId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<RentalTerm> rentalTerms = this.repository.getAll();
        System.out.println("In getall, all = " + rentalTerms);
    }
}
