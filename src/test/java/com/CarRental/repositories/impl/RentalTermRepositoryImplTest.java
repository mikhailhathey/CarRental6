package com.CarRental.repositories.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.factories.RentalTermFactory;
import com.CarRental.repositories.RentalTermRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentalTermRepositoryImplTest {

    private RentalTermRepository repository;
    private RentalTerm rentalTerm;

    private RentalTerm getSavedRentalTerm() {
        Set<RentalTerm> savedRentalTerms = this.repository.getAll();
        return savedRentalTerms.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.rentalTerm);
    }

    @Test
    public void b_read() {
       RentalTerm savedRentalTerm = getSavedRentalTerm();
        System.out.println("In read, rentalTermId = "+ savedRentalTerm.getRentalTermId());
        RentalTerm read = this.repository.read(savedRentalTerm.getRentalTermId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRentalTerm, read);
    }

    @Test
    public void e_delete() {
        RentalTerm savedRentalTerm = getSavedRentalTerm();
        this.repository.delete(savedRentalTerm.getRentalTermId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test RentalTerm Name";
        RentalTerm rentalTerm = new RentalTerm.Builder().copy(getSavedRentalTerm()).rentalTermBranch(newname).build();
        System.out.println("In update, about_to_updated = " + rentalTerm);
        RentalTerm updated = this.repository.update(rentalTerm);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getRentalTermBranch());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<RentalTerm> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
